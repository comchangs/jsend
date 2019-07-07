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

import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

/**
 * JSendTest
 *
 * @author Murry Jeong (comchangs@gmail.com)
 */
public class JSendTest {

  @Test
  public void ok_with_noting() {
    JSend success = JSend.success();
    assertEquals(success.toJsonString(), "{\"status\":\"success\"}");
  }

  @Test
  public void ok_with_data() {
    Pet pet = new Pet("moon");
    JSend success = JSend.success(pet);
    assertEquals(success.toJsonString(), "{\"status\":\"success\",\"data\":{\"name\":\"moon\"}}");
  }

  @Test
  public void error_with_message() {
    JSend error = JSend.error("It has been occurred an error.");
    assertEquals(error.toJsonString(), "{\"status\":\"error\",\"message\":\"It has been occurred an error.\"}");
  }

  @Test
  public void error_with_code_message_and_data() {
    Pet pet = new Pet("moon");
    JSend error = JSend.error(500, "It has been occurred an error.", pet);
    assertEquals(error.toJsonString(), "{\"status\":\"error\",\"code\":500,\"message\":\"It has been occurred an error.\",\"data\":{\"name\":\"moon\"}}");
  }

  @Test
  public void fail_with_data() {
    Pet pet = new Pet("moon");
    JSend fail = JSend.fail(pet);
    assertEquals(fail.toJsonString(), "{\"status\":\"fail\",\"data\":{\"name\":\"moon\"}}");
  }

  private class Pet {
    private final String name;

    public Pet(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Pet.class.getSimpleName() + "[", "]")
          .add("name='" + name + "'")
          .toString();
    }
  }
}
