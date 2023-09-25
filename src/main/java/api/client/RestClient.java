package api.client;

import kong.unirest.Unirest;
import api.entity.*;

import java.util.List;

public class RestClient extends BaseClient {

    //todo: make all paths constants
    public static final String CHECK_TOKENS_PATH = "/public/api/v1/access-tokens/check";
    public static final String GET_DAY_CANDLES_PATH = "/public/api/v1/day-candles";
    public static final String GET_INTRADAY_CANDLES_PATH = "/public/api/v1/intraday-candles";
    public static final String ORDERS_PATH = "/public/api/v1/orders";
    public static final String PORTFOLIO_PATH = "/public/api/v1/portfolio";
    public static final String SECURITIES_PATH = "/public/api/v1/securities";
    public static final String STOPS_PATH = "/public/api/v1/stops";

    //X-Api-Key header may be


    public RestClient() {
        if (!getSheme().isEmpty() && !getUrl().isEmpty())
            Unirest.config().defaultBaseUrl(getSheme() + "://" + getUrl());
        else Unirest.config().defaultBaseUrl("https://trade-api.finam.ru");
    }

    public RestClient(String sheme, String host) {
        if (!sheme.isEmpty() && !host.isEmpty()) {
            Unirest.config().defaultBaseUrl(sheme + "://" + host);
        } else {
            throw new IllegalArgumentException("sheme and url must not be null or empty");
        }
    }

    public RestClient(String url) {
        if (!url.isEmpty()) {
            Unirest.config().defaultBaseUrl(url);
        } else {
            throw new IllegalArgumentException("url must not be null or empty");
        }
    }

    public long checkToken() {
        IdResultWebResponse response = Unirest.get("{path}")
                .header("Authorization", "Bearer " + getToken())
                .routeParam("path", CHECK_TOKENS_PATH)
                .asObject(IdResultWebResponse.class)
                .getBody();

        //todo: code is in words? not numbers. need to find them
        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data().id();
        }
    }

    //todo: two funcs below are the same on 99% ...combine?

    public DayCandle[] getDayCandles(String securityBoard,
                                     String securityCode,
                                     String timeFrame, //Available values : D1, W1
                                     String intervalFrom,
                                     String intervalTo,
                                     int intervalCount) {

        if (securityBoard.isEmpty() | securityCode.isEmpty() | timeFrame.isEmpty() |
        intervalFrom.isEmpty() | intervalTo.isEmpty())
            throw new IllegalArgumentException("parameters must be set");

        GetDayCandlesResultWebResponse response = Unirest.get("{path}")
                .header("Authorization", "Bearer " + getToken())
                .routeParam("path", GET_DAY_CANDLES_PATH)
                .queryString("SecurityBoard", securityBoard)
                .queryString("SecurityCode", securityCode)
                .queryString("TimeFrame", timeFrame)
                .queryString("Interval.From", intervalFrom)
                .queryString("Interval.To", securityBoard)
                .queryString("Interval.Count", intervalCount)
                .asObject(GetDayCandlesResultWebResponse.class)
                .getBody();

        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data().candles();
        }
    }


    public IntradayCandle[] getIntradayCandles(String securityBoard,
                                               String securityCode,
                                               String timeFrame, //Available values : M1, M5, M15, H1
                                               String intervalFrom,
                                               String intervalTo,
                                               int intervalCount) {

        if (securityBoard.isEmpty() | securityCode.isEmpty() | timeFrame.isEmpty() |
                intervalFrom.isEmpty() | intervalTo.isEmpty())
            throw new IllegalArgumentException("parameters must be set");

        GetIntradayCandlesResultWebResponse response = Unirest.get("{path}")
                .header("Authorization", "Bearer " + getToken())
                .routeParam("path", GET_INTRADAY_CANDLES_PATH)
                .queryString("SecurityBoard", securityBoard)
                .queryString("SecurityCode", securityCode)
                .queryString("TimeFrame", timeFrame)
                .queryString("Interval.From", intervalFrom)
                .queryString("Interval.To", securityBoard)
                .queryString("Interval.Count", intervalCount)
                .asObject(GetIntradayCandlesResultWebResponse.class)
                .getBody();

        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data().candles();
        }
    }

    public int setOrder(NewOrderRequest order) {

        if (order == null)
            throw new IllegalArgumentException("order is null");

        NewOrderResultWebResponse response = Unirest.post("{path}")
                .header("Authorization", "Bearer " + getToken())
                .header("Content-Type", "application/json")
                .routeParam("path", ORDERS_PATH)
                .body(order)
                .asObject(NewOrderResultWebResponse.class)
                .getBody();

        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data().transactionId();
        }

    }

    public int cancelOrder(String clientId, int transactionId) {

        if (clientId.isEmpty() | transactionId == 0)
            throw new IllegalArgumentException("arguments musr be set");

        CancelOrderResultWebResponse response = Unirest.delete("{path}")
                .header("Authorization", "Bearer " + getToken())
                .routeParam("path", ORDERS_PATH)
                .queryString("ClientId", clientId)
                .queryString("TransactionId", transactionId)
                .asObject(CancelOrderResultWebResponse.class)
                .getBody();

        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data().transactionId();
        }
    }

    public List<Order> getOrderList(String clientId,
                                    boolean includeMatched,
                                    boolean includeCanceled,
                                    boolean includeActive) {

        if (clientId.isEmpty() && (!includeMatched && !includeCanceled && !includeActive))
            throw new IllegalArgumentException("client ID not set or all bool parameters are incorrect");

        GetOrdersResultWebResponse response = Unirest.get("{path}")
                .header("Authorization", "Bearer " + getToken())
                .routeParam("path", ORDERS_PATH)
                .queryString("ClientId", clientId)
                .queryString("IncludeMatched", includeMatched)
                .queryString("IncludeCanceled", includeCanceled)
                .queryString("IncludeActive",includeActive)
                .asObject(GetOrdersResultWebResponse.class)
                .getBody();

        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data().orders();
        }
    }

    public GetPortfolioResult getPortfolio(String clientId,
                                           boolean includeCurrencies,
                                           boolean includeMoney,
                                           boolean includePositions,
                                           boolean includeMaxBuySell) {

        if (clientId.isEmpty() && (!includeCurrencies && !includeMoney && !includePositions && !includeMaxBuySell))
            throw new IllegalArgumentException("client ID not set or all bool parameters are incorrect");

        GetPortfolioResultWebResponse response = Unirest.get("{path}")
                .header("Authorization", "Bearer " + getToken())
                .routeParam("path", PORTFOLIO_PATH)
                .queryString("ClientId", clientId)
                .queryString("Content.IncludeCurrencies", includeCurrencies)
                .queryString("Content.IncludeMoney", includeMoney)
                .queryString("Content.IncludePositions", includePositions)
                .queryString("Content.IncludeMaxBuySell", includeMaxBuySell)
                .asObject(GetPortfolioResultWebResponse.class)
                .getBody();

        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data();
        }

    }

    //todo: what is the request is????
    public List<Security> getSecurities(GetSecuritiesRequest request) {

        if (request == null)
            throw new IllegalArgumentException("order is null");

        GetSecuritiesResultWebResponse response = Unirest.get("{path}")
                .header("Authorization", "Bearer " + getToken())
                .routeParam("path", SECURITIES_PATH)
                .queryString("request", request)
                .asObject(GetSecuritiesResultWebResponse.class)
                .getBody();

        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data().securities();
        }

    }

    public NewStopResult setStopOrder(NewStopRequest request) {

        if (request == null)
            throw new IllegalArgumentException("Stop order is null");

        NewStopResultWebResponse response = Unirest.post("{path}")
                .header("Authorization", "Bearer " + getToken())
                .routeParam("path", STOPS_PATH)
                .body(request)
                .asObject(NewStopResultWebResponse.class)
                .getBody();

        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data();
        }

    }

    public List<Stop> getStopOrdersList(String clientId,
                                        boolean includeExecuted,
                                        boolean includeCanceled,
                                        boolean includeActive) {

        if (clientId.isEmpty() && (!includeExecuted && !includeCanceled && !includeActive))
            throw new IllegalArgumentException("order must be set");

        GetStopsResultWebResponse response = Unirest.get("{path}")
                .header("Authorization", "Bearer " + getToken())
                .routeParam("path", STOPS_PATH)
                .queryString("ClientId", clientId)
                .queryString("IncludeExecuted", includeExecuted)
                .queryString("IncludeCanceled", includeCanceled)
                .queryString("IncludeActive", includeActive)
                .asObject(GetStopsResultWebResponse.class)
                .getBody();

        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data().stops();
        }
    }

    public int deleteStop(String clientId, int stopId) {

        if (clientId.isEmpty() || stopId == 0)
            throw new IllegalArgumentException("arguments must be set");

        CancelStopResultWebResponse response = Unirest.delete("{path}")
                .header("Authorization", "Bearer " + getToken())
                .routeParam("path", STOPS_PATH)
                .queryString("ClientId", clientId)
                .queryString("StopId", stopId)
                .asObject(CancelStopResultWebResponse.class)
                .getBody();

        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return response.data().stopId();
        }
    }

}
