package api.entity;

/**
 *
 * @param type
 * @param price Значение для условия.
 * @param time Время, когда заявка была отменена на сервере. В UTC. "2023-09-28T05:48:51Z"
 */
public record OrderCondition(OrderConditionType type,
                             double price,
                             String time) {
}
