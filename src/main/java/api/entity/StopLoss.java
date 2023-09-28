package api.entity;

/**
 *
 * @param activationPrice - цена активации;
 * @param price - цена условной заявки. В случае рыночной цены значение должно быть 0;
 * @param marketPrice - значение true указывает на то, что необходимо выставить рыночную заявку,
 *                    иначе выставляется условная заявка с ценой price;
 * @param quantity - объем заявки. Тип StopQuantity;
 * @param time - защитное время (секунды);
 * @param useCredit - использование кредита (недоступно для срочного рынка).
 *                  Указать значение true, если необходимо использовать кредит, иначе false.
 */
public record StopLoss(double activationPrice,
                       double price,
                       boolean marketPrice,
                       StopQuantity quantity,
                       int time,
                       boolean useCredit) {
}
