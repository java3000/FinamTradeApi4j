package api.entity;

/**
 *
 * @param orderNo
 * @param transactionId
 * @param securityCode
 * @param clientId
 * @param status
 * @param buySell
 * @param createdAt
 * @param price
 * @param quantity
 * @param balance
 * @param message
 * @param currency
 * @param condition
 * @param validBefore
 * @param acceptedAt
 * @param securityBoard
 * @param market
 */
public record Order(long orderNo,
                    int transactionId,
                    String securityCode,
                    String clientId,
                    OrderStatus status,
                    BuySell buySell,
                    String createdAt,
                    double price,
                    int quantity,
                    int balance,
                    String message,
                    String currency,
                    OrderCondition condition,
                    OrderValidBefore validBefore,
                    String acceptedAt,
                    String securityBoard,
                    Market market) {
}
