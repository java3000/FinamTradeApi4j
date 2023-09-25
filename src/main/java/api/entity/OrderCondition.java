package api.entity;

/**
 *
 * @param type
 * @param price
 * @param time
 */
public record OrderCondition(OrderConditionType type,
                             double price,
                             String time) {
}
