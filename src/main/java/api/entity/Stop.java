package api.entity;

/**
 *
 * @param stopId
 * @param securityCode
 * @param securityBoard
 * @param market
 * @param clientId
 * @param buySell
 * @param expirationDate
 * @param linkOrder
 * @param validBefore
 * @param status
 * @param message
 * @param orderNo
 * @param tradeNo
 * @param acceptedAt
 * @param canceledAt
 * @param currency
 * @param takeProfitExtremum
 * @param takeProfitLevel
 * @param stopLoss
 * @param takeProfit
 */
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
