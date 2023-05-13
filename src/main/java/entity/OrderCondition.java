package entity;

public record OrderCondition(OrderConditionType type,
                             double price,
                             String time) {
}
