package coins.analyzer.jsonCmcModel;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class CoinsCmcJson {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("symbol")
    String symbol;

    @SerializedName("rank")
    String rank;

    @SerializedName("price_usd")
    String price_usd;

    @SerializedName("price_btc")
    String price_btc;

    @SerializedName("24h_volume_usd")
    String h24_volume_usd;

    @SerializedName("market_cap_usd")
    String market_cap_usd;

    @SerializedName("available_supply")
    String available_supply;

    @SerializedName("max_supply")
    String max_supply;

    @SerializedName("percent_change_1h")
    String percent_change_1h;

    @SerializedName("percent_change_24h")
    String percent_change_24h;

    @SerializedName("percent_change_7d")
    String percent_change_7d;

    @SerializedName("last_updated")
    String last_updated;

    @SerializedName("price_rub")
    String price_rub;

    @SerializedName("24h_volume_rub")
    String h24_volume_rub;

    @SerializedName("market_cap_rub")
    String market_cap_rub;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRank() {
        return Integer.parseInt(rank);
    }

    public BigDecimal getPriceUsd() {
        return new BigDecimal(price_usd);
    }

    public BigDecimal getPriceBtc() {
        return new BigDecimal(price_btc);
    }

    public BigDecimal getH24VolumeUsd() {
        return new BigDecimal(h24_volume_usd);
    }

    public BigDecimal getMarketCapUsd() {
        return new BigDecimal(market_cap_usd);
    }

    public BigDecimal getAvailableSupply() {
        return new BigDecimal(available_supply);
    }

    public BigDecimal getMaxSupply() {
        return new BigDecimal(max_supply);
    }

    public BigDecimal getPercentChange1h() {
        return new BigDecimal(percent_change_1h);
    }

    public BigDecimal getPercentChange24h() {
        return new BigDecimal(percent_change_24h);
    }

    public BigDecimal getPercentChange7d() {
        return new BigDecimal(percent_change_7d);
    }

    public int getLastUpdated() {
        return Integer.parseInt(last_updated);
    }

    public BigDecimal getPriceRub() {
        return new BigDecimal(price_rub);
    }

    public BigDecimal getH24VolumeRub() {
        return new BigDecimal(h24_volume_rub);
    }

    public BigDecimal getMarketCapRub() {
        return new BigDecimal(market_cap_rub);
    }
}
