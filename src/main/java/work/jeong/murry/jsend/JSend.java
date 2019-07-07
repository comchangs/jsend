/*
 * MIT License
 *
 * Copyright (c) 2019 Murry Jeong (comchangs@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package work.jeong.murry.jsend;

import java.util.StringJoiner;

import static work.jeong.murry.jsend.JSendStatus.*;

/**
 * JSend
 * A library used for generating Json String of JSend
 *
 * @author Murry Jeong (comchangs@gmail.com)
 */
public class JSend {

  private final JSendStatus status;

  private final Integer code;

  private final String message;

  private final Object data;

  /**
   * JSend
   *
   * @param status status for response
   * @param code status code for response
   * @param message An error message
   * @param data An object for data in response
   */
  public JSend(JSendStatus status, Integer code, String message, Object data) {
    this.status = status;
    this.code = code;
    this.message = message;
    this.data = data;
  }

  /**
   * ToJsonString
   *
   * @return Json String of JSend
   */
  public String toJsonString() {
    return JsonUtils.toJson(this);
  }

  /**
   * toString
   *
   * @return String
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
   * success with data
   *
   * @param data An object for data in response
   * @return JSend
   */
  public static JSend success(Object data) {
    return new JSend(success, null, null, data);
  }

  /**
   * success without data
   *
   * @return JSend
   */
  public static JSend success() {
    return success(null);
  }

  /**
   * error with code, message and data
   *
   * @param code status code for response
   * @param message An error message
   * @param data An object for data in response
   * @return JSend
   */
  public static JSend error(Integer code, String message, Object data) {
    return new JSend(error, code, message, data);
  }

  /**
   * error with message only
   *
   * @param message An error message
   * @return JSend
   */
  public static JSend error(String message) {
    return error(null, message, null);
  }

  /**
   * fail with data
   *
   * @param data An object for data in response
   * @return Jsend
   */
  public static JSend fail(Object data) {
    return new JSend(fail, null, null, data);
  }

}
