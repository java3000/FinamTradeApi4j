package api.entity;

/**
 *
 * @param market
 * @param currency
 * @param balance
 */
public record MoneyRow(Market market, String currency, double balance) {
}
