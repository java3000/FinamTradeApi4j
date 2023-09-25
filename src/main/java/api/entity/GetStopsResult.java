package api.entity;

import java.util.List;

/**
 *
 * @param clientId
 * @param stops
 */
public record GetStopsResult(String clientId, List<Stop> stops) {
}
