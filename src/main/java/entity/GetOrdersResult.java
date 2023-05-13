package entity;

import java.util.List;

public record GetOrdersResult(String clientId, List<Order> orders) {
}
