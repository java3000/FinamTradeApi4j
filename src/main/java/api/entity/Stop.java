package api.entity;

/**
 *
 * @param stopId - идентификатор стоп-заявки;
 * @param securityCode - код инструмента;
 * @param securityBoard - основной режим торгов инструмента;
 * @param market - рынок инструмента. Тип Market;
 * @param clientId - торговый код клиента;
 * @param buySell - тип BuySell;
 * @param expirationDate - дата экспирации заявки FORTS;
 * @param linkOrder - биржевой номер связанной (активной) заявки;
 * @param validBefore - условие по времени действия заявки. Тип OrderValidBefore.
 * @param status - текущий статус стоп-заявки. Тип StopStatus;
 * @param message - содержит сообщение об ошибке, возникшей при обработке заявки.
 *                Заявка может быть отклонена по разным причинам сервером TRANSAQ
 *                или биржей с выставлением поля status;
 * @param orderNo - номер заявки, полученной в результате исполнения стоп-заявки;
 * @param tradeNo - номер сделки, которая привела к исполнению стоп-заявки;
 * @param acceptedAt - время регистрации заявки на сервере TRANSAQ (UTC);
 * @param canceledAt - время отмены заявки на сервере TRANSAQ (UTC);
 * @param currency - валюта цены;
 * @param takeProfitExtremum - текущий локальный экстремум для TP;
 * @param takeProfitLevel - текущий уровень коррекции для TP;
 * @param stopLoss - информация об stop-loss. Тип StopLoss;
 * @param takeProfit - информация об take-profit. Тип TakeProfit.
 */
public record Stop(int stopId,
                   String securityCode,
                   String securityBoard,
                   Market market,
                   String clientId,
                   BuySell buySell,
                   String expirationDate,
                   long linkOrder,
                   OrderValidBefore validBefore,
                   StopStatus status,
                   String message,
                   long orderNo,
                   long tradeNo,
                   String acceptedAt,
                   String canceledAt,
                   String currency,
                   double takeProfitExtremum,
                   double takeProfitLevel,
                   StopLoss stopLoss,
                   TakeProfit takeProfit) {
}
