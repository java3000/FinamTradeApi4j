package api.entity;

/**
 *
 * @param code- код инструмента;
 * @param board - основной режим торгов инструмента;
 * @param market - рынок инструмента. Тип Market;
 * @param decimals - количество знаков в дробной части цены;
 * @param lotSize - размер лота;
 * @param minStep - минимальный шаг цены;
 * @param currency - код валюты номинала цены;
 * @param instrumentCode - код инструмента;
 * @param shortName - название инструмента;
 * @param properties - параметры инструмента. Значение представлено в виде битовой маски:
 *
 * 0 - нет параметров;
 * 1 - инструмент торгуется на бирже;
 * 2 - инструмент допущен к торгам у брокера - существенно для НЕ ГЛАВНЫХ трейдеров.
 *                   Главным доступны все инструменты, торгуемые на биржах;
 * 4 - рыночные заявки (без ограничения по цене) разрешены;
 * 8 - признак маржинальности бумаги;
 * 16 - опцион Call;
 * 32 - опцион Put;
 * 48 - фьючерс Call | Put;
 * 64 - разрешен для резидентов;
 * 128 - разрешен для нерезидентов.
 * @param timeZoneName - имя таймзоны;
 * @param bpCost - стоимость пункта цены одного инструмента (не лота), без учета НКД;
 * @param accruedInterest- текущий НКД;
 * @param priceSign - допустимая цена инструмента. Принимает следующие значения:
 *
 * Positive - положительная,
 * NonNegative - неотрицательная,
 * Any - любая.
 * @param ticker - тикер инструмента на биржевой площадке листинга;
 * @param lotDivider - коэффициент дробления ценной бумаги в одном стандартном лоте.
 */
public record Security(String code,
                       String board,
                       Market market,
                       int decimals,
                       int lotSize,
                       int minStep,
                       String currency,
                       String instrumentCode,
                       String shortName,
                       int properties,
                       String timeZoneName,
                       double bpCost,
                       double accruedInterest,
                       PriceSign priceSign,
                       String ticker,
                       int lotDivider) {
}
