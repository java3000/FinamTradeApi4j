package api.entity;

/**
 *
 * @param includeCurrencies
 * @param includeMoney
 * @param includePositions
 * @param includeMaxBuySell
 */
public record PortfolioContent(boolean includeCurrencies,
                               boolean includeMoney,
                               boolean includePositions,
                               boolean includeMaxBuySell) {
}
