package api.entity;

public interface Response<T> {
    WebError error();

    Result data();

}
