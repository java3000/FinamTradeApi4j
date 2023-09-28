package api.entity;

/**
 * езультат GetIntradayCandlesRequest.
 *
 * @param candles Список свечей.
 */
public record GetIntradayCandlesResult(IntradayCandle[] candles) {
}
