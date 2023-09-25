package api.entity;

public record IntradayCandle(String date,
                             Decimal open,
                             Decimal close,
                             Decimal high,
                             Decimal low,
                             int volume) {
}
