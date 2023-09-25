package api.entity;

public record DayCandle(String date,
                        Decimal open,
                        Decimal close,
                        Decimal high,
                        Decimal low,
                        int volume) {
}
