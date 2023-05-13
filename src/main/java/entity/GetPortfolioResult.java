package entity;

import java.util.List;

public record GetPortfolioResult(String clientId,
                                 PortfolioContent content,
                                 double equity,
                                 double balance,
                                 List<PositionRow> positions,
                                 List<CurrencyRow> currencies,
                                 List<MoneyRow> money) {
}
