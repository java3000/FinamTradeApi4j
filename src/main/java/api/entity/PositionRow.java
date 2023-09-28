package api.entity;

/**
 *
 * @param securityCode - код инструмента;
 * @param market - рынок инструмента. Тип Market;
 * @param balance
 * @param currentPrice - текущая цена в валюте инструмента;
 * @param equity - текущая оценка инструмента;
 * @param averagePrice - средняя цена;
 * @param currency- код валюты риска;
 * @param accumulatedProfit - прибыль/убыток по входящим;
 * @param todayProfit - прибыль/убыток по сделкам;
 * @param unrealizedProfit - нереализованная прибыль/убыток;
 * @param profit - прибыль/убыток;
 * @param maxBuy - максимально возможное количество лотов на покупку
 *               (вычисляется, если указать флаг includeMaxBuySell в true, иначе значение будет равно 0);
 * @param maxSell - максимально возможное количество лотов на продажу
 *               (вычисляется, если указать флаг includeMaxBuySell в true, иначе значение будет равно 0);
 * @param priceCurrency - код валюты цены;
 * @param averagePriceCurrency - код валюты балансовой цены;
 * @param averageRate - кросс-курс валюты балансовой цены к валюте риска.
 */
public record PositionRow(String securityCode,
                          Market market,
                          long balance,
                          double currentPrice,
                          double equity,
                          double averagePrice,
                          String currency,
                          double accumulatedProfit,
                          double todayProfit,
                          double unrealizedProfit,
                          double profit,
                          long maxBuy,
                          long maxSell,
                          String priceCurrency,
                          String averagePriceCurrency,
                          double averageRate) {
}
