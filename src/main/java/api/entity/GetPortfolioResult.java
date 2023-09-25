package api.entity;

import java.util.List;

/**
 *
 * @param clientId
 * @param content
 * @param equity
 * @param balance
 * @param positions
 * @param currencies
 * @param money
 */
public record GetPortfolioResult(String clientId,
                                 PortfolioContent content,
                                 double equity,
                                 double balance,
                                 List<PositionRow> positions,
                                 List<CurrencyRow> currencies,
                                 List<MoneyRow> money) {
}
