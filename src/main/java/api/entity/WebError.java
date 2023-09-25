package api.entity;

/**
 *
 * @param code
 * @param message
 * @param data
 */
public record WebError(String code, String message, Object data) {
}
