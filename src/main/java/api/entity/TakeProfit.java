package api.entity;

/**
 *
 * @param activationPrice
 * @param correctionPrice
 * @param spreadPrice
 * @param marketPrice
 * @param quantity
 * @param time
 * @param useCredit
 */
public record TakeProfit(double activationPrice,
                         StopPrice correctionPrice,
                         StopPrice spreadPrice,
                         boolean marketPrice,
                         StopQuantity quantity,
                         int time,
                         boolean useCredit) {
}
