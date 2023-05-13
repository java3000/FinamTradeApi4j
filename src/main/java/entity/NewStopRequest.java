package entity;

public record NewStopRequest(String clientId,
                             String securityBoard,
                             String securityCode,
                             BuySell buySell,
                             StopLoss stopLoss,
                             TakeProfit takeProfit,
                             String expirationDate,
                             long linkOrder,
                             OrderValidBefore validBefore) {
}
