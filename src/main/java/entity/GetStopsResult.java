package entity;

import java.util.List;

public record GetStopsResult(String clientId, List<Stop> stops) {
}
