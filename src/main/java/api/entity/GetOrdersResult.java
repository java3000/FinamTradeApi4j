package api.entity;

import java.util.List;

/**
 *
 * @param clientId
 * @param orders
 */
public record GetOrdersResult(String clientId, List<Order> orders) {
}
