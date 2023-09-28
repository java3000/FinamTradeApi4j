package api.client;

public abstract class BaseClient implements ApiClient {
    public static final String CHECK_TOKENS_PATH = "/public/api/v1/access-tokens/check";
    public static final String GET_DAY_CANDLES_PATH = "/public/api/v1/day-candles";
    public static final String GET_INTRADAY_CANDLES_PATH = "/public/api/v1/intraday-candles";
    public static final String ORDERS_PATH = "/public/api/v1/orders";
    public static final String PORTFOLIO_PATH = "/public/api/v1/portfolio";
    public static final String SECURITIES_PATH = "/public/api/v1/securities";
    public static final String STOPS_PATH = "/public/api/v1/stops";
    public static final String FINAM_API_DEFAULT_URL = "https://trade-api.finam.ru";
    private String token;
    private String url;
    private String sheme;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSheme() {
        return sheme;
    }

    public void setSheme(String sheme) {
        this.sheme = sheme;
    }
}
