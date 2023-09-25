package api.entity;

/**
 *
 * @param clientId
 * @param stopId
 * @param securityCode
 * @param securityBoard
 */
public record NewStopResult(String clientId,
                            int stopId,
                            String securityCode,
                            String securityBoard) {
}
