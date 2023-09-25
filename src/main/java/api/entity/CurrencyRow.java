package api.entity;

/**
 *
 * @param name
 * @param balance
 * @param crossRate
 * @param equity
 * @param unrealizedProfit
 */
public record CurrencyRow(String name,
                          double balance,
                          double crossRate,
                          double equity,
                          double unrealizedProfit) {
}
