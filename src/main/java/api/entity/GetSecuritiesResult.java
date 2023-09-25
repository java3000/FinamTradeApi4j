package api.entity;

import java.util.List;

/**
 *
 * @param securities
 */
public record GetSecuritiesResult(List<Security> securities) {
}
