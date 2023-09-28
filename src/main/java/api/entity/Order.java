package api.entity;

/**
 *
 * @param orderNo - уникальный идентификатор заявки на бирже.
 *                Задается после того, как заявка будет принята биржей (см. поле status);
 * @param transactionId - внутренний идентификатор заявки в системе TRANSAQ
 *                      (для чужой заявки значение всегда равно 0);
 * @param securityCode - код инструмента;
 * @param clientId - торговый код клиента;
 * @param status - текущий статус заявки. Тип OrderStatus;
 * @param buySell- тип BuySell;
 * @param createdAt - время регистрации заявки на бирже (UTC);
 * @param price - цена исполнения условной заявки.
 *              Для рыночной заявки значение всегда равно 0;
 * @param quantity - объем заявки в лотах;
 * @param balance - неисполненный остаток, в лотах.
 *                Изначально равен quantity, но по мере исполнения заявки (совершения сделок)
 *                будет уменьшаться на объем сделки.
 *                Значение 0 будет соответствовать полностью исполненной заявке (см. поле status);
 * @param message - содержит сообщение об ошибке, возникшей при обработке заявки.
 *               Заявка может быть отклонена по разным причинам сервером TRANSAQ
 *               или биржей с выставлением поля status;
 * @param currency - код валюты цены;
 * @param condition - свойства выставления заявок. Тип OrderCondition;
 * @param validBefore - условие по времени действия заявки. Тип OrderValidBefore;
 * @param acceptedAt - время регистрации заявки на сервере TRANSAQ (UTC);
 * @param securityBoard - основной режим торгов инструмента;
 * @param market - рынок инструмента. Тип Market.
 */
public record Order(long orderNo,
                    int transactionId,
                    String securityCode,
                    String clientId,
                    OrderStatus status,
                    BuySell buySell,
                    String createdAt,
                    double price,
                    int quantity,
                    int balance,
                    String message,
                    String currency,
                    OrderCondition condition,
                    OrderValidBefore validBefore,
                    String acceptedAt,
                    String securityBoard,
                    Market market) {
}
