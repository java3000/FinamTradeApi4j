package api.entity;

/**
 * Какие данные будут в ответе.
 * @param includeCurrencies Валютные позиции.
 * @param includeMoney Денежные позиции.
 * @param includePositions Позиции DEPO.
 * @param includeMaxBuySell Лимиты покупки и продажи.
 */
public record PortfolioContent(boolean includeCurrencies,
                               boolean includeMoney,
                               boolean includePositions,
                               boolean includeMaxBuySell) {
}
