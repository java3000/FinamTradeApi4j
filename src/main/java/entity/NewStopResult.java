package entity;

public record NewStopResult(String clientId,
                            int stopId,
                            String securityCode,
                            String securityBoard) {
}
