package entity;

public record CurrencyRow(String name,
                          double balance,
                          double crossRate,
                          double equity,
                          double unrealizedProfit) {
}
