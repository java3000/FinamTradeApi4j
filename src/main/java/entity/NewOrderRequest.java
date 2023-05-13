package entity;

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
