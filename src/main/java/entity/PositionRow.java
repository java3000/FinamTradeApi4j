package entity;

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
