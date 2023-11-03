package api.client;

import api.client.grpc.controller.GrpcController;
import com.google.protobuf.BlockingRpcChannel;
import com.google.protobuf.ServiceException;
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

    public List<Sheme.DayCandle> getDayCandles() throws ServiceException {
        var blockingStub = Sheme.Candles.newBlockingStub(channel);
        Sheme.GetDayCandlesResult result = blockingStub.getDayCandles(new GrpcController(),
                Sheme.GetDayCandlesRequest.newBuilder().build());

        return result.getCandlesList();
    }

    //todo create daycandles func with parameters. if possible

    public List<Sheme.IntradayCandle> getIntradayCandles() throws ServiceException {
        var blockingStub = Sheme.Candles.newBlockingStub(channel);
        Sheme.GetIntradayCandlesResult result = blockingStub.getIntradayCandles(new GrpcController(),
                Sheme.GetIntradayCandlesRequest.newBuilder().build());

        return result.getCandlesList();
    }

    //todo create intradaycandles func with parameters. if possible
    public int setOrder() throws ServiceException {
        var stub = Sheme.Orders.newBlockingStub(channel);

        //todo add parameters to request
        var result = stub.newOrder(new GrpcController(), Sheme.NewOrderRequest.getDefaultInstance().toBuilder().build());

        return result.getTransactionId();
    }

    //==============================

    public int cancelOrder() throws ServiceException {
        var stub = Sheme.Orders.newBlockingStub(channel);

        //todo add parameters to request
        var result = stub.cancelOrder(new GrpcController(), Sheme.CancelOrderRequest.getDefaultInstance().toBuilder().build());

        return result.getTransactionId();
    }

    // getOrderList
    public List<Sheme.Order> getOrders() throws ServiceException {
        var stub = Sheme.Orders.newBlockingStub(channel);

        //todo add parameters to request
        var result = stub.getOrders(new GrpcController(), Sheme.GetOrdersRequest.getDefaultInstance().toBuilder().build());

        return result.getOrdersList();
    }

    public Sheme.PortfolioContent getPortfolio() throws ServiceException {
        var stub = Sheme.Portfolios.newBlockingStub(channel);

        //todo add parameters to request
        var result = stub.getPortfolio(new GrpcController(), Sheme.GetPortfolioRequest.getDefaultInstance().toBuilder().build());

        return result.getContent();
    }

    public List<Sheme.Security> getSecurities() throws ServiceException {
        var stub = Sheme.Securities.newBlockingStub(channel);

        //todo add parameters to request
        var result = stub.getSecurities(new GrpcController(), Sheme.GetSecuritiesRequest.getDefaultInstance().toBuilder().build());

        return result.getSecuritiesList();
    }

    public int setStopOrder() throws ServiceException {
        var stub = Sheme.Stops.newBlockingStub(channel);

        //todo add parameters to request
        var result = stub.newStop(new GrpcController(), Sheme.NewStopRequest.getDefaultInstance().toBuilder().build());

        return result.getStopId();
    }

    public List<Sheme.Stop> getStopOrdersList() throws ServiceException {
        var stub = Sheme.Stops.newBlockingStub(channel);

        //todo add parameters to request
        var result = stub.getStops(new GrpcController(), Sheme.GetStopsRequest.getDefaultInstance().toBuilder().build());

        return result.getStopsList();
    }

    public int deleteStopOrder() throws ServiceException {
        var stub = Sheme.Stops.newBlockingStub(channel);

        //todo add parameters to request
        var result = stub.cancelStop(new GrpcController(), Sheme.CancelStopRequest.getDefaultInstance().toBuilder().build());

        return result.getStopId();
    }

}
