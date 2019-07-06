package work.jeong.murry.jsend;

import java.util.StringJoiner;

import static work.jeong.murry.jsend.JSendStatus.*;

/**
 * TODO
 */
public class JSend {

  private final JSendStatus status;

  private final Integer code;

  private final String message;

  private final Object data;

  /**
   * TODO
   * @param status
   * @param code
   * @param message
   * @param data
   */
  public JSend(JSendStatus status, Integer code, String message, Object data) {
    this.status = status;
    this.code = code;
    this.message = message;
    this.data = data;
  }

  /**
   * TODO
   * @return
   */
  public String toJsonString() {
    return JsonUtils.toJson(this);
  }

  /**
   * TODO
   * @return
   */
  @Override
  public String toString() {
    return new StringJoiner(", ", JSend.class.getSimpleName() + "[", "]")
        .add("status=" + status)
        .add("code=" + code)
        .add("message='" + message + "'")
        .add("data='" + data + "'")
        .toString();
  }

  /**
   * TODO
   * @param data
   * @return
   */
  public static JSend success(Object data) {
    return new JSend(success, null, null, data);
  }

  /**
   * TODO
   * @return
   */
  public static JSend success() {
    return success(null);
  }

  /**
   * TODO
   * @param code
   * @param message
   * @param data
   * @return
   */
  public static JSend error(Integer code, String message, Object data) {
    return new JSend(error, code, message, data);
  }

  /**
   * TODO
   * @param message
   * @return
   */
  public static JSend error(String message) {
    return error(null, message, null);
  }

  /**
   * TODO
   * @param data
   * @return
   */
  public static JSend fail(Object data) {
    return new JSend(fail, null, null, data);
  }

}
