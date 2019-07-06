package work.jeong.murry.jsend;

import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

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
