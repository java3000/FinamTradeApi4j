package api.entity;

/**
 * Условие по времени действия заявки.
 * @param type
 * @param time Время, когда заявка была отменена на сервере. В UTC. "2023-09-28T05:48:51Z"
 */
public record OrderValidBefore(OrderValidBeforeType type, String time) {
}
