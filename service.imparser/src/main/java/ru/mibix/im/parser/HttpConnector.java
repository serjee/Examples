package ru.mibix.im.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Класс для работы с HTTP-запросами
 */
public class HttpConnector
{
    private static final Logger log = LogManager.getLogger(HttpConnector.class.getName());

    /**
     * Хранение ответа на запрос
     */
    private StringBuffer response;

    /**
     * URL-запроса
     */
    private String url;

    /**
     * Конструктор
     *
     * @param url String - URL адрес запроса
     */
    public HttpConnector(String url)
    {
        this.url = url;
    }

    /**
     * Отправляем GET-запрос
     *
     * @throws Exception
     */
    public void sendGetRq()
    {
        try {
            this.sendHttpRq(0, false);
        } catch (Exception e) {
            log.error("Request issue : " + e.getMessage());
        }
    }

    /**
     * Получаем результат запроса
     *
     * @return - объект с результатом запроса
     */
    public StringBuffer responseGetRq()
    {
        return response;
    }

    /**
     * Send GET http query
     *
     * @throws Exception
     */
    private void sendHttpRq(int typeRq, boolean isSSL) throws Exception
    {
        response = null;

        String USER_AGENT = "Mozilla/5.0";
        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        if (isSSL)
            con = (HttpsURLConnection) obj.openConnection();

        // optional default
        con.setRequestProperty("User-Agent", USER_AGENT);
        if (typeRq == 0)
        {
            con.setRequestMethod("GET");
        }
        else
        {
            String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            log.debug("Post parameters : " + urlParameters);
        }

        int responseCode = con.getResponseCode();
        log.info("Sending 'GET' request to URL : " + url);
        log.info("Response code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        response = new StringBuffer();

        while ((inputLine = in.readLine()) != null)
        {
            response.append(inputLine);
        }
        in.close();

        //print result
        log.info("Response on request : " + response.toString());
    }

}