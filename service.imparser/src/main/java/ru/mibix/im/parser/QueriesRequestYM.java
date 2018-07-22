package ru.mibix.im.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.mibix.im.parser.json.*;

import java.io.*;
import java.net.URLEncoder;

/**
 * Класс для работы с запросами Yandex Market
 */
public class QueriesRequestYM
{
    private static final Logger log = LogManager.getLogger(QueriesRequestYM.class.getName());

    /**
     * API-ключ сервиса apisystem.ru
     */
    private static final String API_KEY = "";

    /**
     * Адрес серсвиса предоставления контентного API Яндекс Маркета
     */
    private static final String MARKET_URL = "http://market.apisystem.ru/";

    /**
     * Формат получения ответа от сервиса
     */
    private static final String OUT_FORMAT = "json";

    /**
     * Переменная для хранения запроса
     */
    private String query;

    /**
     * Конструктор
     */
    public QueriesRequestYM() { }

    /**
     * Конструктор
     */
    public QueriesRequestYM(String api, String param)
    {
        buildQuery(api, param);
    }

    /**
     * Установка GET-запроса к Яндекс Маркет
     *
     * @param api - адрес API-запроса
     * @param param - параметры API-запроса
     */
    private void buildQuery(String api, String param)
    {
        this.query = MARKET_URL + api + "." + OUT_FORMAT +"?" + param + "&api_key=" + API_KEY;
        log.debug("Build query : " + MARKET_URL + api + "." + OUT_FORMAT + "?" + param);
    }

    /**
     * Получаем текущий GET запрос к Яндекс Маркет
     *
     * @return - текущий GET-запрос
     */
    private String getQuery()
    {
        return query;
    }

    /**
     * Отправка HTTP-запроса и получение ответа
     */
    private StringBuffer sendRequest()
    {
        HttpConnector httpCon = new HttpConnector(getQuery());
        httpCon.sendGetRq();

        return httpCon.responseGetRq();
    }

    /**
     * Получить файл JSON (временная эмуляция ответа от Яндекс)
     *
     * @return - результат
     */
    private String getFileJSON()
    {
        try
        {
            File file = new File("search.json");
            final int length = (int) file.length();
            if (length != 0)
            {
                char[] cbuf = new char[length];
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file),"UTF-8");
                final int read = isr.read(cbuf);
                isr.close();

                log.info("File " + file.getName() + " is found!");

                return new String(cbuf, 0, read);
            }
        }
        catch (Exception e)
        {
            log.error("File read error : " + e.getMessage());
        }

        return "";
    }

    /**
     * Текстовый поиск моделей
     *
     * @param text - текст поиска
     */
    public void searchText(String text)
    {
        try
        {
            //buildQuery("v1/search", "text=" + URLEncoder.encode(text, "UTF-8"));
            //StringBuffer jsonResult = sendRequest();

            //TODO: сохраняем полный ответ в базу данных

            // Парсим JSON-ответ и заполняем данными объект модели
            //JsonArray jsonResults = Json.parse(jsonResult.toString()).asObject().get("searchResult").asObject().get("results").asArray();
            JsonArray jsonResults = Json.parse(getFileJSON()).asObject().get("searchResult").asObject().get("results").asArray();
            for (JsonValue model : jsonResults)
            {
                //TODO: нужно выделить данные из ответа и занести их в объект модели, затем сохранить эту модель в базе данных со ссылками на магазин, который произвел запрос
                log.info(model.toString());

                //int mId = model.asObject().get("model").asObject().getInt("id", 0);
                //String name = model.asObject().get("model").asObject().getString("name", "Unknown Name");
                //String link = model.asObject().get("model").asObject().getString("link", "Unknown Link");

                //log.debug("ID : " + mId + "; Name : " + name + "; Link : " + link);
            }

            //TODO: обновляем статус запроса в таблице im_queries
        }
        catch (Exception e)
        {
            log.error("Search text error : " + e.getMessage());
        }

    }
}
