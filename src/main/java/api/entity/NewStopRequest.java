package api.entity;

/**
 *
 * @param clientId
 * @param securityBoard
 * @param securityCode
 * @param buySell
 * @param stopLoss
 * @param takeProfit
 * @param expirationDate
 * @param linkOrder
 * @param validBefore
 */
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
