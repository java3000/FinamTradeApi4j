package api.entity;

/**
 * Дневная свеча.
 *
 * @param date   - дата свечи в формате yyyy-MM-dd (в локальном времени биржи);
 * @param open   - цена открытия (тип Decimal);
 * @param close  - цена закрытия (тип Decimal);
 * @param high   - максимальная цена (тип Decimal);
 * @param low    - минимальная цена (тип Decimal);
 * @param volume - объем торгов.
 */
public record DayCandle(String date,
                        Decimal open,
                        Decimal close,
                        Decimal high,
                        Decimal low,
                        int volume) {
}
