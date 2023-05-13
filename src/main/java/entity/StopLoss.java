package entity;

public record StopLoss(double activationPrice,
                       double price,
                       boolean marketPrice,
                       StopQuantity quantity,
                       int time,
                       boolean useCredit) {
}
