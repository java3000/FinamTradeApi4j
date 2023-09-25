package api.entity;

/**
 *
 * @param clientId
 * @param transactionId
 * @param securityCode
 */
public record NewOrderResult(String clientId, int transactionId, String securityCode) {
}
