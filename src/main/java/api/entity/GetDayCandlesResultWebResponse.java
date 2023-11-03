package api.entity;

public record GetDayCandlesResultWebResponse(WebError error, GetDayCandlesResult data)
        implements Response<GetDayCandlesResultWebResponse> {
}
