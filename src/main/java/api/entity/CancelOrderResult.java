package api.entity;

/**
 * Результат выполнения CancelOrderRequest.
 * @param clientId Идентификатор торгового счёта.
 * @param transactionId Идентификатор транзакции, который может быть использован для отмены заявки
 *                      или определения номера заявки в сервисе событий.
 */
public record CancelOrderResult(String clientId, int transactionId) {
}
