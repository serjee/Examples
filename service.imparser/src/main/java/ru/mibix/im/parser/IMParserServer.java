package ru.mibix.im.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Точка входа
 */
public class IMParserServer
{
    private static final Logger log = LogManager.getLogger(IMParserServer.class.getName());
    //log.debug("Hello world - debug log");
    //log.info("Hello world - info log");
    //log.warn("Hello world - warn log");
    //log.error("Hello world - error log");

    /**
     * Точка входа в приложение
     *
     * @param args - аргументы запуска
     */
    public static void main (String args[])
    {
        log.info("Start main thread.");

        try
        {
            // Создаем и запускаем поток для мониторинга запросов к Яндекс Маркет от Битрикс-модуля
            QueriesServerYM qsym = new QueriesServerYM("QueriesServerYM");
            qsym.t.join();
        }
        catch (InterruptedException e)
        {
            log.error("Main thread is crashed.");
        }

        log.info("Main thread is end.");
    }



}
