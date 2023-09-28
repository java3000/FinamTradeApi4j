package api.entity;

/**
 * Внетридневная свеча.
 *
 * @param date   - дата и время свечи в формате yyyy-MM-ddTHH:mm:ssZ в поясе UTC;
 * @param open   - цена открытия (тип Decimal);
 * @param close  - цена закрытия (тип Decimal);
 * @param high   - максимальная цена (тип Decimal);
 * @param low    - минимальная цена (тип Decimal);
 * @param volume - объем торгов.
 */
public record IntradayCandle(String date,
                             Decimal open,
                             Decimal close,
                             Decimal high,
                             Decimal low,
                             int volume) {
}
