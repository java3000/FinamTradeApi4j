package api.entity;

/**
 *
 * @param error
 * @param data
 */
public record IdResultWebResponse(WebError error, IdResult data) implements Response<IdResultWebResponse> {
}
