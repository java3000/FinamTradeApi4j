package api.entity;

/**
 * Результат GetDatCandlesRequest.
 *
 * @param candles Список свечей.
 */
public record GetDayCandlesResult(DayCandle[] candles) implements Result<GetDayCandlesResult> {
}
