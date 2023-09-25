package api.entity;

/**
 * Обозначает время действия заявки. Тип условия определяет значение поля type, которое принимает следующие параметры:
 *
 * TillEndSession - заявка действует до конца сессии;
 * TillCancelled - заявка действует, пока не будет отменена;
 * ExactTime - заявка действует до указанного времени. Параметр time должен быть задан.
 */
public enum OrderValidBeforeType {
    TillEndSession, TillCancelled, ExactTime
}
