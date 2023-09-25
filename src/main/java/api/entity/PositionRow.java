package api.entity;

/**
 *
 * @param securityCode
 * @param market
 * @param balance
 * @param currentPrice
 * @param equity
 * @param averagePrice
 * @param currency
 * @param accumulatedProfit
 * @param todayProfit
 * @param unrealizedProfit
 * @param profit
 * @param maxBuy
 * @param maxSell
 * @param priceCurrency
 * @param averagePriceCurrency
 * @param averageRate
 */
public record PositionRow(String securityCode,
                          Market market,
                          long balance,
                          double currentPrice,
                          double equity,
                          double averagePrice,
                          String currency,
                          double accumulatedProfit,
                          double todayProfit,
                          double unrealizedProfit,
                          double profit,
                          long maxBuy,
                          long maxSell,
                          String priceCurrency,
                          String averagePriceCurrency,
                          double averageRate) {
}
