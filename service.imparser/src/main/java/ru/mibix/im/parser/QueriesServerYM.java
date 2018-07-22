package ru.mibix.im.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.mibix.im.parser.dao.*;
import ru.mibix.im.parser.dao.impl.*;
import ru.mibix.im.parser.model.Queries;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Класс для парсинга товара в отдельном потоке
 */
public class QueriesServerYM implements Runnable
{
    private static final Logger log = LogManager.getLogger(QueriesServerYM.class.getName());

    /**
     * Максимальное количество потоков для обработки запросов
     */
    private static final int MAX_THREAD = 10;

    /**
     * Имя потока
     */
    String name;

    /**
     * Объект потока
     */
    Thread t;

    /**
     * Конструктор - создание нового потока при инициализации
     *
     * @param threadname - имя потока
     */
    public QueriesServerYM(String threadname)
    {
        name = threadname;
        log.info(name + " thread is starting.");

        t = new Thread(this, name);
        t.start();
    }

    /**
     * Инициализация действи при запуске потока
     */
    public void run()
    {
        try
        {
            while(true)
            {
                queriesInit();
                Thread.sleep(1000); // задержка в 1 секунду
            }
        }
        catch (Exception e)
        {
            log.error(name + " thread is crash with error : " + e.getMessage());
        }
    }

    /**
     * Поиск и обработка необработанных запросов в базе данных
     *
     * @throws DaoException
     * @throws SQLException
     */
    private void queriesInit() throws DaoException, SQLException
    {
        // Получаем из БД необработоанные запросы (Статус=0)
        DbDaoFactory factory = new DbDaoFactory();
        QueriesDao queriesDAO = factory.getQueriesDao();
        List<Queries> lq = queriesDAO.getQueriesByStatus(0);

        // Если есть необработанные запросы, обрабатываем их в новых потоках
        if (lq.size()>0)
        {
            log.info(name + " thread : " + lq.size() + " pending requests.");

            // Максимальный лимит потоков, остальные добавляются в очередь
            final Semaphore semaphore = new Semaphore(MAX_THREAD);

            // Создаем пул в размере количества ожидающих запросов из базы и добавляем их в него
            QueriesPoolYM pool = new QueriesPoolYM(lq.size());
            for (Queries qrs : lq)
            {
                pool.addTask(() -> {
                    try
                    {
                        log.debug(name + " thread : processing query ID : " + qrs.getId());

                        semaphore.acquire(); // пытаемся получить свободный ресурс из доступного лимита
                        try
                        {
                            QueriesRequestYM ymrq = new QueriesRequestYM();
                            ymrq.searchText(qrs.getName());
                        }
                        catch (Exception e)
                        {
                            log.error(name + " thread is crash with error : " + e.getMessage());
                        }
                        finally
                        {
                            semaphore.release(); // освобождаем занятый ресурс
                        }
                        log.debug(name + ". End processing query ID : " + qrs.getId());
                    }
                    catch (InterruptedException e)
                    {
                        log.error(name + " thread interrupted : " + e.getMessage());
                    }
                });
            }
            pool.shutdown();
        }
    }
}
