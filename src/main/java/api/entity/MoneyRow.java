package api.entity;

/**
 * Денежная позиция.
 * @param market - рынок. Тип Market;
 * @param currency - код валюты;
 * @param balance - текущая позиция.
 */
public record MoneyRow(Market market, String currency, double balance) {
}
