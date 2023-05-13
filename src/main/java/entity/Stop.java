package entity;

public record Stop(int stopId,
                   String securityCode,
                   String securityBoard,
                   Market market,
                   String clientId,
                   BuySell buySell,
                   String expirationDate,
                   long linkOrder,
                   OrderValidBefore validBefore,
                   StopStatus status,
                   String message,
                   long orderNo,
                   long tradeNo,
                   String acceptedAt,
                   String canceledAt,
                   String currency,
                   double takeProfitExtremum,
                   double takeProfitLevel,
                   StopLoss stopLoss,
                   TakeProfit takeProfit) {
}
