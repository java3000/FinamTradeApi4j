package api.entity;

public record GetIntradayCandlesResultWebResponse(WebError error, GetIntradayCandlesResult data)
        implements Response<GetIntradayCandlesResultWebResponse> {
}
