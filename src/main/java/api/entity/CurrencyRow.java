package api.entity;

/**
 * Валютная позиция.
 * @param name - код валюты;
 * @param balance - текущая позиция;
 * @param crossRate - курс валюты;
 * @param equity - оценка позиции;
 * @param unrealizedProfit - нереализованная прибыль/убыток в рублях.
 */
public record CurrencyRow(String name,
                          double balance,
                          double crossRate,
                          double equity,
                          double unrealizedProfit) {
}
