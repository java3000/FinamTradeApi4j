package api.entity;

/**
 * Запрос на создание заявки.
 * @param clientId - торговый код клиента;
 * @param securityBoard - основной режим торгов для инструмента;
 * @param securityCode - код инструмента;
 * @param buySell- тип BuySell;
 * @param quantity - объем заявки в лотах;
 * @param useCredit - использование кредита (недоступно для срочного рынка).
 *                  Указать значение true, если необходимо использовать кредит, иначе false.
 * @param price  - цена исполнения заявки.
 *               Для рыночной заявки указать значение 0.
 *               Для условной заявки необходимо указать цену исполнения;
 * @param property - свойства исполнения частично исполненных заявок.
 *                 Принимает следующие значения:
 *                 PutInQueue - неисполненная часть заявки помещается в очередь заявок биржи;
 * CancelBalance - неисполненная часть заявки снимается с торгов;
 * ImmOrCancel - сделки совершаются только в том случае,
 *                 если заявка может быть удовлетворена полностью и сразу при выставлении.
 * @param condition - свойства выставления заявок. Тип OrderCondition;
 * @param validBefore  - условие по времени действия заявки. Тип OrderValidBefore.
 */
public record NewOrderRequest(String clientId,
                              String securityBoard,
                              String securityCode,
                              BuySell buySell,
                              int quantity,
                              boolean useCredit,
                              double price,
                              OrderProperty property,
                              OrderCondition condition,
                              OrderValidBefore validBefore) {
}
