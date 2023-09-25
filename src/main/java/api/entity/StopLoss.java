package api.entity;

/**
 *
 * @param activationPrice
 * @param price
 * @param marketPrice
 * @param quantity
 * @param time
 * @param useCredit
 */
public record StopLoss(double activationPrice,
                       double price,
                       boolean marketPrice,
                       StopQuantity quantity,
                       int time,
                       boolean useCredit) {
}
