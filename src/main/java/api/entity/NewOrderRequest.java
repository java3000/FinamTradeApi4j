package api.entity;

/**
 *
 * @param clientId
 * @param securityBoard
 * @param securityCode
 * @param buySell
 * @param quantity
 * @param useCredit
 * @param price
 * @param property
 * @param condition
 * @param validBefore
 */
public record NewOrderRequest(String clientId,
                              String securityBoard,
                              String securityCode,
                              BuySell buySell,
                              int quantity,
                              boolean useCredit,
                              double price,
                              OrderProperty property,
                              OrderCondition condition,
                              OrderValidBefore validBefore) {
}
