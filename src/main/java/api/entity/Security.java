package api.entity;

/**
 *
 * @param code
 * @param board
 * @param market
 * @param decimals
 * @param lotSize
 * @param minStep
 * @param currency
 * @param instrumentCode
 * @param shortName
 * @param properties
 * @param timeZoneName
 * @param bpCost
 * @param accruedInterest
 * @param priceSign
 * @param ticker
 * @param lotDivider
 */
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
