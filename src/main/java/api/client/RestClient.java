package api.client;

import api.entity.*;
import kong.unirest.Unirest;

import java.util.List;

public class RestClient extends BaseClient {

    public RestClient() {
        if (!getSheme().isEmpty() && !getUrl().isEmpty())
            Unirest.config().defaultBaseUrl(getSheme() + "://" + getUrl());
        else Unirest.config().defaultBaseUrl(FINAM_API_DEFAULT_URL);
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

    /**
     * Проверка токена
     *
     * @return числовой идентификатор
     */
    public long checkToken() {
        Response<IdResultWebResponse> response = Unirest.get("{path}")
                .header("X-Api-Key", getToken())
                .routeParam("path", CHECK_TOKENS_PATH)
                .asObject(IdResultWebResponse.class)
                .getBody();

        return ((IdResult) validateResponse(response)).id();
    }

    /**
     *
     * @param securityBoard Режим торгов.
     * @param securityCode Тикер инструмента.
     * @param timeFrame Временной интервал. Возможные значения: D1 (день), W1 (неделя)
     * @param intervalFrom Дата начала. Дата (по времени биржи). "2023-05-25"
     * @param intervalTo Дата окончания. Дата (по времени биржи). "2023-05-25"
     * @param intervalCount Количество свечей.
     * @return Возвращает дневные свечи
     */
    public DayCandle[] getDayCandles(String securityBoard,
                                     String securityCode,
                                     String timeFrame,
                                     String intervalFrom,
                                     String intervalTo,
                                     int intervalCount) {

        if (securityBoard.isEmpty() | securityCode.isEmpty() | timeFrame.isEmpty())
            throw new IllegalArgumentException("parameters must be set");

        Response<GetDayCandlesResultWebResponse> response = Unirest.get("{path}")
                .header("X-Api-Key", getToken())
                .routeParam("path", GET_DAY_CANDLES_PATH)
                .queryString("SecurityBoard", securityBoard)
                .queryString("SecurityCode", securityCode)
                .queryString("TimeFrame", timeFrame)
                .queryString("Interval.From", intervalFrom)
                .queryString("Interval.To", intervalTo)
                .queryString("Interval.Count", intervalCount)
                .asObject(GetDayCandlesResultWebResponse.class)
                .getBody();

        return ((GetDayCandlesResult) validateResponse(response)).candles();
    }


    /**
     *
     * @param securityBoard Режим торгов.
     * @param securityCode Тикер инструмента.
     * @param timeFrame Временной интервал. M1, M5, M15, H1
     * @param intervalFrom Дата начала. Время, когда заявка была отменена на сервере. В UTC. "2023-09-28T05:48:51Z"
     * @param intervalTo Дата окончания.  Время, когда заявка была отменена на сервере. В UTC. "2023-09-28T05:48:51Z"
     * @param intervalCount Количество свечей.
     * @return Возвращает внутридневные свечи.
     */
    public IntradayCandle[] getIntradayCandles(String securityBoard,
                                               String securityCode,
                                               String timeFrame,
                                               String intervalFrom,
                                               String intervalTo,
                                               int intervalCount) {

        if (securityBoard.isEmpty() | securityCode.isEmpty() | timeFrame.isEmpty())
            throw new IllegalArgumentException("parameters must be set");

        Response<GetIntradayCandlesResultWebResponse> response = Unirest.get("{path}")
                .header("X-Api-Key", getToken())
                .routeParam("path", GET_INTRADAY_CANDLES_PATH)
                .queryString("SecurityBoard", securityBoard)
                .queryString("SecurityCode", securityCode)
                .queryString("TimeFrame", timeFrame)
                .queryString("Interval.From", intervalFrom)
                .queryString("Interval.To", intervalTo)
                .queryString("Interval.Count", intervalCount)
                .asObject(GetIntradayCandlesResultWebResponse.class)
                .getBody();

        return ((GetIntradayCandlesResult) validateResponse(response)).candles();
    }

    /**
     * Создать новую заявку.
     * На обработку нового поручения по размещению заявки в биржевой стакан
     * требуется некоторое время, поэтому этот метод возвращает структуру с
     * transaction_id, которая может быть использована для поиска соответствующей
     * заявки через GetOrdersRequest или в сообщении OrderEvent от сервиса событий
     * (EventResponse.event.order).
     * @param order @href NewOrderRequest
     * @return В случае успешного выполнения запроса сервис вернет transactionId выставленной заявки.
     */
    public int setOrder(NewOrderRequest order) {

        if (order == null)
            throw new IllegalArgumentException("order is null");

        Response<NewOrderResultWebResponse> response = Unirest.post("{path}")
                .header("X-Api-Key", getToken())
                .header("Content-Type", "application/json")
                .routeParam("path", ORDERS_PATH)
                .body(order)
                .asObject(NewOrderResultWebResponse.class)
                .getBody();

        return ((NewOrderResult) validateResponse(response)).transactionId();
    }

    /**
     * Отменяет заявку.
     * @param clientId - Идентификатор торгового счёта.
     * @param transactionId - Идентификатор транзакции,
     * который может быть использован для отмены заявки или определения номера заявки в сервисе событий.
     * @return
     */
    public int cancelOrder(String clientId, int transactionId) {

        if (clientId.isEmpty() | transactionId == 0)
            throw new IllegalArgumentException("arguments musr be set");

        Response<CancelOrderResultWebResponse> response = Unirest.delete("{path}")
                .header("X-Api-Key", getToken())
                .routeParam("path", ORDERS_PATH)
                .queryString("ClientId", clientId)
                .queryString("TransactionId", transactionId)
                .asObject(CancelOrderResultWebResponse.class)
                .getBody();

        return ((CancelOrderResult) validateResponse(response)).transactionId();
    }

    /**
     * Возвращает список заявок.
     * @param clientId - торговый код клиента (обязательный);
     * @param includeMatched - вернуть исполненные заявки;
     * @param includeCanceled- вернуть отмененные заявки;
     * @param includeActive - вернуть активные заявки.
     * @return В случае успешного выполнения запроса сервис вернет список заявок.
     */
    public List<Order> getOrderList(String clientId,
                                    boolean includeMatched,
                                    boolean includeCanceled,
                                    boolean includeActive) {

        if (clientId.isEmpty() && (!includeMatched && !includeCanceled && !includeActive))
            throw new IllegalArgumentException("client ID not set or all bool parameters are incorrect");

        Response<GetOrdersResultWebResponse> response = Unirest.get("{path}")
                .header("X-Api-Key", getToken())
                .routeParam("path", ORDERS_PATH)
                .queryString("ClientId", clientId)
                .queryString("IncludeMatched", includeMatched)
                .queryString("IncludeCanceled", includeCanceled)
                .queryString("IncludeActive",includeActive)
                .asObject(GetOrdersResultWebResponse.class)
                .getBody();

        return ((GetOrdersResult) validateResponse(response)).orders();
    }

    /**
     * Возвращает портфель.
     * @param clientId - торговый код клиента (обязательный);
     * @param includeCurrencies - запросить информацию по валютам портфеля;
     * @param includeMoney - запросить информацию по денежным позициям портфеля;
     * @param includePositions - запросить информацию по позициям портфеля;
     * @param includeMaxBuySell - запросить информацию о максимальном доступном объеме на покупку/продажу.
     * @return В случае успешного выполнения запроса сервис вернет портфель клиента.
     */
    public GetPortfolioResult getPortfolio(String clientId,
                                           boolean includeCurrencies,
                                           boolean includeMoney,
                                           boolean includePositions,
                                           boolean includeMaxBuySell) {

        if (clientId.isEmpty() && (!includeCurrencies && !includeMoney && !includePositions && !includeMaxBuySell))
            throw new IllegalArgumentException("client ID not set or all bool parameters are incorrect");

        Response<GetPortfolioResultWebResponse> response = Unirest.get("{path}")
                .header("X-Api-Key", getToken())
                .routeParam("path", PORTFOLIO_PATH)
                .queryString("ClientId", clientId)
                .queryString("Content.IncludeCurrencies", includeCurrencies)
                .queryString("Content.IncludeMoney", includeMoney)
                .queryString("Content.IncludePositions", includePositions)
                .queryString("Content.IncludeMaxBuySell", includeMaxBuySell)
                .asObject(GetPortfolioResultWebResponse.class)
                .getBody();

        return validateResponse(response);
    }

    /**
     * Справочник инструментов.
     * @param request The request received from the client.
     * @return
     */
    //todo: what is the request is????
    public List<Security> getSecurities(GetSecuritiesRequest request) {

        if (request == null)
            throw new IllegalArgumentException("order is null");

        Response<GetSecuritiesResultWebResponse> response = Unirest.get("{path}")
                .header("X-Api-Key", getToken())
                .routeParam("path", SECURITIES_PATH)
                .queryString("request", request)
                .asObject(GetSecuritiesResultWebResponse.class)
                .getBody();

        return ((GetSecuritiesResult) validateResponse(response)).securities();
    }

    /**
     * Выставляет стоп-заявку.
     * @param request The request received from the client.
     * @return
     */
    public NewStopResult setStopOrder(NewStopRequest request) {

        if (request == null)
            throw new IllegalArgumentException("Stop order is null");

        Response<NewStopResultWebResponse> response = Unirest.post("{path}")
                .header("X-Api-Key", getToken())
                .routeParam("path", STOPS_PATH)
                .body(request)
                .asObject(NewStopResultWebResponse.class)
                .getBody();

        return validateResponse(response);
    }

    /**
     * Возвращает список стоп-заявок.
     * @param clientId - торговый код клиента (обязательный);
     * @param includeExecuted - вернуть исполненные заявки;
     * @param includeCanceled - вернуть отмененные заявки;
     * @param includeActive - вернуть активные заявки.
     * @return В случае успешного выполнения запроса сервис вернет список стоп-заявок.
     */
    public List<Stop> getStopOrdersList(String clientId,
                                        boolean includeExecuted,
                                        boolean includeCanceled,
                                        boolean includeActive) {

        if (clientId.isEmpty() && (!includeExecuted && !includeCanceled && !includeActive))
            throw new IllegalArgumentException("order must be set");

        Response<GetStopsResultWebResponse> response;
        try {
            response = Unirest.get("{path}")
                    .header("X-Api-Key", getToken())
                    .routeParam("path", STOPS_PATH)
                    .queryString("ClientId", clientId)
                    .queryString("IncludeExecuted", includeExecuted)
                    .queryString("IncludeCanceled", includeCanceled)
                    .queryString("IncludeActive", includeActive)
                    .asObject(GetStopsResultWebResponse.class)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ((GetStopsResult) validateResponse(response)).stops();
    }

    /**
     * Снимает стоп-заявку.
     * @param clientId - торговый код клиента;
     * @param stopId - идентификатор отменяемой стоп-заявки.
     * @return идентификатор отменяемой стоп-заявки
     */
    public int deleteStopOrder(String clientId, int stopId) {

        if (clientId.isEmpty() || stopId == 0)
            throw new IllegalArgumentException("arguments must be set");

        Response<CancelStopResultWebResponse> response;

        try {
            response = Unirest.delete("{path}")
                    .header("X-Api-Key", getToken())
                    .routeParam("path", STOPS_PATH)
                    .queryString("ClientId", clientId)
                    .queryString("StopId", stopId)
                    .asObject(CancelStopResultWebResponse.class)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ((CancelStopResult) validateResponse(response)).stopId();
    }

    public <T extends Result<?>, P extends Response<?>> T validateResponse(P response) {
        if (!response.error().code().equals("SUCCESS")) {
            switch (response.error().code()) {
                case "UNAUTHENTICATED" -> throw new IllegalArgumentException(response.error().message());
                case "TOO_MANY_REQUESTS" -> throw new IllegalStateException(response.error().message());
                default -> throw new IllegalStateException("Unexpected value: " + response.error().code());
            }
        } else {
            return (T) response.data();
        }
    }

}
