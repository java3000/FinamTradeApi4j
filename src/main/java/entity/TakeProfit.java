package entity;

public record TakeProfit(double activationPrice,
                         StopPrice correctionPrice,
                         StopPrice spreadPrice,
                         boolean marketPrice,
                         StopQuantity quantity,
                         int time,
                         boolean useCredit) {
}
