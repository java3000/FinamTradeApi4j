package api.client;

public abstract class BaseClient implements ApiClient {
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
