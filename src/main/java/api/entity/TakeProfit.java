package api.entity;

/**
 *
 * @param activationPrice - цена активации;
 * @param correctionPrice - коррекция. Тип StopPrice;
 * @param spreadPrice - защитный спред. В случае рыночной цены значение должно быть 0. Тип StopPrice;
 * @param marketPrice - значение true указывает на то, что необходимо выставить рыночную заявку,
 *                    иначе выставляется условная заявка с ценой price;
 * @param quantity - объем заявки. Тип StopQuantity;
 * @param time - защитное время (секунды);
 * @param useCredit - использование кредита (недоступно для срочного рынка). Указать значение true,
 *                  если использовать кредит, иначе false.
 */
public record TakeProfit(double activationPrice,
                         StopPrice correctionPrice,
                         StopPrice spreadPrice,
                         boolean marketPrice,
                         StopQuantity quantity,
                         int time,
                         boolean useCredit) {
}
