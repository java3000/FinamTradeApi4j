package api.entity;

/**
 * езультат отмены стоп-заявки.
 * @param clientId Идентификатор торгового счёта.
 * @param stopId Идентификатор стоп-заявки.
 */
public record CancelStopResult(String clientId, int stopId) {
}
