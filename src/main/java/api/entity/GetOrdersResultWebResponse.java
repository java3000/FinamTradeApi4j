package api.entity;

/**
 *
 * @param error
 * @param data
 */
public record GetOrdersResultWebResponse(WebError error, GetOrdersResult data)
        implements Response<GetOrdersResultWebResponse> {
}
