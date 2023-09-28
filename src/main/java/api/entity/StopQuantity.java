package api.entity;

/**
 * Значение объема.
 * @param value - значение объема, единицы измерения которого зависят от значения поля units;
 * @param units - единицы измерения объема. Принимает следующие значения:
 *
 * Percent - проценты,
 * Lots - лоты.
 */
public record StopQuantity(double value, StopQuantityUnits units) {
}
