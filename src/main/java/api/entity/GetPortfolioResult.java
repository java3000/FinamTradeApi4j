package api.entity;

import java.util.List;

/**
 * Результат GetPortfolioRequest.
 * @param clientId - торговый код клиента;
 * @param content - наполнение портфеля;
 * @param equity - текущая оценка портфеля;
 * @param balance - входящая оценка стоимости портфеля;
 * @param positions - позиции портфеля.
 *                  Массив объектов типа PositionRow.
 *                  Запрашиваются выставлением флага includePositions равным true;
 * @param currencies - валюта портфеля.
 *                   Массив объектов типа CurrencyRow.
 *                   Запрашивается выставлением флага includeCurrencies равным true;
 * @param money - денежные позиции.
 *              Массив объектов типа MoneyRow.
 *              Запрашивается выставлением флага includeMoney равным true.
 */
public record GetPortfolioResult(String clientId,
                                 PortfolioContent content,
                                 double equity,
                                 double balance,
                                 List<PositionRow> positions,
                                 List<CurrencyRow> currencies,
                                 List<MoneyRow> money) {
}
