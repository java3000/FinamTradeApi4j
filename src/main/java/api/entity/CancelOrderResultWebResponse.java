package api.entity;

/**
 *
 * @param error
 * @param data
 */
public record CancelOrderResultWebResponse(WebError error, CancelOrderResult data) {
}
