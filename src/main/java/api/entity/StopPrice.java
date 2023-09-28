package api.entity;

/**
 *
 * @param value - значение цены, единицы измерения которой зависят от значения поля units;
 * @param units - единицы измерения цены. Принимает следующие значения:
 *
 * Percent - проценты,
 * Pips - единицы цены.
 */
public record StopPrice(double value, StopPriceUnits units) {
}
