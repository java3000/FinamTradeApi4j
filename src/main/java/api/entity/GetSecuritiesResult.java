package api.entity;

import java.util.List;

/**
 * Результат выполнения запроса списка инструментов.
 * @param securities Список инструментов.
 */
public record GetSecuritiesResult(List<Security> securities) implements Result<GetSecuritiesResult> {
}
