package api.entity;

/**
 *
 * @param clientId
 * @param transactionId
 */
public record CancelOrderResult(String clientId, int transactionId) {
}
