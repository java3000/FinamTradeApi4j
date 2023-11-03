package api.entity;

/**
 *
 * @param error
 * @param data
 */
public record GetStopsResultWebResponse(WebError error, GetStopsResult data)
        implements Response<GetStopsResultWebResponse> {
}
