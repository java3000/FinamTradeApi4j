package api.entity;

import java.util.List;

/**
 * Результат запроса стоп-заявок.
 * @param clientId Идентификатор торгового счёта.
 * @param stops Список стоп-заявок.
 */
public record GetStopsResult(String clientId, List<Stop> stops) {
}
