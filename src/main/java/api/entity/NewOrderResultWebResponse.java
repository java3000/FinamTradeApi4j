package api.entity;

/**
 *
 * @param error
 * @param data
 */
public record NewOrderResultWebResponse(WebError error, NewOrderResult data)
        implements Response<NewOrderResultWebResponse> {
}
