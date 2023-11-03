package api.entity;

/**
 *
 * @param error
 * @param data
 */
public record CancelStopResultWebResponse(WebError error, CancelStopResult data)
        implements Response<CancelStopResultWebResponse> {
}
