package api.entity;

/**
 * Результат выполнения NewOrderRequest.
 * @param clientId Идентификатор торгового счёта.
 * @param transactionId Идентификатор транзакции, который может быть использован для отмены заявки
 *                     или определения номера заявки в сервисе событий.
 * @param securityCode Тикер инструмента.
 */
public record NewOrderResult(String clientId, int transactionId, String securityCode) {
}
