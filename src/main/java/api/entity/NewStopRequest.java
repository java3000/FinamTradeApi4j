package api.entity;

/**
 *
 * @param clientId - торговый код клиента;
 * @param securityBoard - основной режим торгов инструмента;
 * @param securityCode - код инструмента;
 * @param buySell - тип BuySell;
 * @param stopLoss - информация о stop-loss. Тип StopLoss;
 * @param takeProfit - информация о take-profit. Тип TakeProfit;
 * @param expirationDate - дата экспирации заявки FORTS;
 * @param linkOrder - биржевой номер связанной (активной) заявки;
 * @param validBefore - условие по времени действия заявки. Тип OrderValidBefore;
 * @param status  - текущий статус стоп-заявки. Тип StopStatus.
 */
public record NewStopRequest(String clientId,
                             String securityBoard,
                             String securityCode,
                             BuySell buySell,
                             StopLoss stopLoss,
                             TakeProfit takeProfit,
                             String expirationDate,
                             long linkOrder,
                             OrderValidBefore validBefore,
                             StopStatus status) {
}
