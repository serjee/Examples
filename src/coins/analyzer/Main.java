package coins.analyzer;

import coins.analyzer.jsonCmcModel.CoinsCmcJson;

import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {

    /**
     * Log
     */
    private static final Logger log = LogManager.getLogger(Main.class.getName());

    /**
     * Main
     */
    public static void main(String[] args) throws Exception
    {
        // get array of coins from cmc
        String json = readUrl("https://api.coinmarketcap.com/v1/ticker/?limit=99999&convert=RUB");
        CoinsCmcJson[] coins = new Gson().fromJson(json, CoinsCmcJson[].class);

        // create hashmap
        Map<String, CoinsCmcJson> coinsmap = new HashMap<>();
        for (int i = 0; i < coins.length; i++) {
            coinsmap.put(coins[i].getId(), coins[i]);
        }

        // get bases of bitcoin
        BigDecimal baseMarketCapUsd = coinsmap.get("bitcoin").getMarketCapUsd();
        BigDecimal baseVolume24H = coinsmap.get("bitcoin").getH24VolumeUsd();

        // calculate each coin
        for(Map.Entry<String, CoinsCmcJson> entry : coinsmap.entrySet()) {

            // todo: get coin from Db by key

            // todo: add to Db if new coin and set datecreate

            entry.getKey();
            entry.getValue();

        }
    }

    /**
     * Get JSON from URL
     *
     * @param urlString - URL
     * @return
     * @throws Exception
     */
    private static String readUrl(String urlString) throws Exception {

        BufferedReader reader = null;

        try {

            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();

        } finally {
            if (reader != null)
                reader.close();
        }
    }

}
