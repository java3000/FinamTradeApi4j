package api.client;

import api.client.grpc.controller.GrpcController;
import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.ServiceException;
import com.google.protobuf.Timestamp;
import io.grpc.ManagedChannelBuilder;

import java.util.List;

public class GrpcClient extends BaseClient {

    BlockingRpcChannel channel;

    public GrpcClient() throws ServiceException {
        this(FINAM_API_DEFAULT_HOST, FINAM_API_DEFAULT_PORT);
    }

    public GrpcClient(String host, int port) throws ServiceException {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public GrpcClient(ManagedChannelBuilder<?> channelBuilder) throws ServiceException {
        channel = (BlockingRpcChannel) channelBuilder.build();
    }

    public List<Sheme.DayCandle> getDayCandles(String securityBoard, String ticker, int timeframe) throws ServiceException {
        var blockingStub = Sheme.Candles.newBlockingStub(channel);
        Sheme.GetDayCandlesResult result = blockingStub.getDayCandles(new GrpcController(),
                Sheme.GetDayCandlesRequest
                        .newBuilder()
                        .setSecurityBoard(securityBoard)
                        .setSecurityCode(ticker)
                        .setTimeFrameValue(timeframe)
                        .build());

        return result.getCandlesList();
    }

    public List<Sheme.IntradayCandle> getIntradayCandles(Sheme.IntradayCandleInterval interval,
                                                         String securityBoard,
                                                         String ticker,
                                                         int timeframe) throws ServiceException {

        var blockingStub = Sheme.Candles.newBlockingStub(channel);
        Sheme.GetIntradayCandlesResult result = blockingStub.getIntradayCandles(new GrpcController(),
                Sheme.GetIntradayCandlesRequest
                        .newBuilder()
                        .setInterval(interval)
                        .setSecurityBoard(securityBoard)
                        .setSecurityCode(ticker)
                        .setTimeFrameValue(timeframe)
                        .build());

        return result.getCandlesList();
    }

    //todo add other method with builders
    public int setOrder(String clientId,
                        int buySellValue,
                        Sheme.OrderCondition orderCondition,
                        DoubleValue price,
                        int quantity,
                        String securityBoard,
                        String ticker,
                        boolean useCredit,
                        Sheme.OrderValidBefore validBeforeValue) throws ServiceException {
        var stub = Sheme.Orders.newBlockingStub(channel);

        var result = stub.newOrder(new GrpcController(), Sheme.NewOrderRequest
                .newBuilder()
                .setClientId(clientId)
                .setBuySellValue(buySellValue)
                .setCondition(orderCondition)
                .setPrice(price)
                .setQuantity(quantity)
                .setSecurityBoard(securityBoard)
                .setSecurityCode(ticker)
                .setUseCredit(useCredit)
                .setValidBefore(validBeforeValue)
                .build());

        return result.getTransactionId();
    }

    public int cancelOrder(String clientId, int orderId) throws ServiceException {
        var stub = Sheme.Orders.newBlockingStub(channel);

        var result = stub.cancelOrder(new GrpcController(), Sheme.CancelOrderRequest
                .newBuilder()
                .setClientId(clientId)
                .setTransactionId(orderId)
                .build());

        return result.getTransactionId();
    }

    // getOrderList
    public List<Sheme.Order> getOrders(String clientId,
                                       boolean includeActive,
                                       boolean includeCanceled,
                                       boolean includeMatched) throws ServiceException {
        var stub = Sheme.Orders.newBlockingStub(channel);

        var result = stub.getOrders(new GrpcController(), Sheme.GetOrdersRequest
                .newBuilder()
                .setClientId(clientId)
                .setIncludeActive(includeActive)
                .setIncludeCanceled(includeCanceled)
                .setIncludeMatched(includeMatched)
                .build());

        return result.getOrdersList();
    }

    public Sheme.PortfolioContent getPortfolio(String clientId) throws ServiceException {
        var stub = Sheme.Portfolios.newBlockingStub(channel);

        var result = stub.getPortfolio(new GrpcController(), Sheme.GetPortfolioRequest
                .newBuilder()
                .setClientId(clientId)
                .build());

        return result.getContent();
    }

    public List<Sheme.Security> getSecurities() throws ServiceException {
        var stub = Sheme.Securities.newBlockingStub(channel);

        var result = stub.getSecurities(new GrpcController(), Sheme.GetSecuritiesRequest.getDefaultInstance().toBuilder().build());

        return result.getSecuritiesList();
    }

    //todo add other method with builders
    public int setStopOrder(int buySellValue,
                            String clientId,
                            Timestamp expirationDate,
                            long orderId,
                            String boardType,
                            String ticker,
                            Sheme.TakeProfit takeProfitValue,
                            Sheme.StopLoss stopLossValue,
                            Sheme.OrderValidBefore validBeforeValue) throws ServiceException {
        var stub = Sheme.Stops.newBlockingStub(channel);

        var result = stub.newStop(new GrpcController(), Sheme.NewStopRequest
                .newBuilder()
                .setBuySellValue(buySellValue)
                .setClientId(clientId)
                .setExpirationDate(expirationDate)
                .setLinkOrder(orderId)
                .setSecurityBoard(boardType)
                .setSecurityCode(ticker)
                .setTakeProfit(takeProfitValue)
                .setStopLoss(stopLossValue)
                .setValidBefore(validBeforeValue)
                .build());

        return result.getStopId();
    }

    public List<Sheme.Stop> getStopOrdersList(String clientId) throws ServiceException {
        var stub = Sheme.Stops.newBlockingStub(channel);

        var result = stub.getStops(new GrpcController(), Sheme.GetStopsRequest
                .newBuilder()
                .setClientId(clientId)
                .build());

        return result.getStopsList();
    }

    public int deleteStopOrder(String clientId, int stopId) throws ServiceException {
        var stub = Sheme.Stops.newBlockingStub(channel);

        var result = stub.cancelStop(new GrpcController(), Sheme.CancelStopRequest
                .newBuilder()
                .setClientId(clientId)
                .setStopId(stopId).
                build());

        return result.getStopId();
    }

}
