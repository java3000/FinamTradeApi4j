package api.entity;

/**
 * @param num   - мантисса;
 * @param scale - экспонента по основанию 10.
 *              Итоговое значение вычисляется по формуле: num * 10^(-scale). Где ^ оператор возведение в степень.
 *              Например: для num = 250655 и scale = 3 итоговое значение будет 250.655.
 */
public record Decimal(int num, int scale) {
}
