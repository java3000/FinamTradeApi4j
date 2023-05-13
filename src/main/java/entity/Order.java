package entity;

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
