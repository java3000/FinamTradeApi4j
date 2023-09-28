package api.entity;

/**
 * Состояние заявки.. Принимает следующие значения:
 *
 * None - заявка принята сервером TRANSAQ, и заявке присвоен transactionId;
 * Active - заявка принята биржей, и заявке присвоен orderNo;
 * Matched - заявка полностью исполнилась (выполнилась);
 * Cancelled - заявка была отменена (снята) пользователем или биржей.
 */
public enum OrderStatus {
    NONE, ACTIVE, CANCELLED, MATCHED
}
