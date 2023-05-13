package entity;

public record PortfolioContent(boolean includeCurrencies,
                               boolean includeMoney,
                               boolean includePositions,
                               boolean includeMaxBuySell) {
}
