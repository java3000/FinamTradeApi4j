package api.entity;

/**
 * Результат выставления стоп заявки.
 * @param clientId Идентификатор торгового счёта.
 * @param stopId Идентификатор стоп заявки.
 * @param securityCode Тикер инструмента.
 * @param securityBoard Режим торгов.
 */
public record NewStopResult(String clientId,
                            int stopId,
                            String securityCode,
                            String securityBoard) {
}
