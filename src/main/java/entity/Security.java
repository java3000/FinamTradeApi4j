package entity;

public record Security(String code,
                       String board,
                       Market market,
                       int decimals,
                       int lotSize,
                       int minStep,
                       String currency,
                       String instrumentCode,
                       String shortName,
                       int properties,
                       String timeZoneName,
                       double bpCost,
                       double accruedInterest,
                       PriceSign priceSign,
                       String ticker,
                       int lotDivider) {
}
