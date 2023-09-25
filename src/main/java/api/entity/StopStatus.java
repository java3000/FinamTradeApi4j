package api.entity;

/**
 *Статус стоп-заявки. Принимает следующие значения:
 *
 * Active - заявка сервером TRANSAQ;
 * Executed - заявка исполнилась (выполнилась);
 * Cancelled - заявка была отменена (снята) пользователем или биржей.
 */
public enum StopStatus {
    NONE, ACTIVE, CANCELED, EXECUTED
}
