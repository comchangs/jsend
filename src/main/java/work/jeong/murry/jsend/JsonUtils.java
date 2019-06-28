package work.jeong.murry.jsend;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JsonUtils {

  private static final Gson GSON = new Gson();

  public static String toJson(Object object) {
    return GSON.toJson(object);
  }

  public static <T> T fromJson(String json, Type type) {
    return GSON.fromJson(json, type);
  }

}
