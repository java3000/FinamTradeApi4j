package api.entity;

import java.util.List;

/**
 * Результат GetOrdersRequest.
 * @param clientId Идентификатор торгового счёта.
 * @param orders Список заявок.
 */
public record GetOrdersResult(String clientId, List<Order> orders) implements Result<GetOrdersResult> {
}
