package api.entity;

/**
 *
 * @param error
 * @param data
 */
public record GetSecuritiesResultWebResponse(WebError error, GetSecuritiesResult data)
        implements Response<GetSecuritiesResultWebResponse> {
}
