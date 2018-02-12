package example.com.mobileexam.utils;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kestrella on 2/9/18.
 */

public class Parser {
  private Parser() {
  }

  public static <T> T parseGeneric(String jsonString, Class<T> clazz) {
    Gson gson = new Gson();
    return gson.fromJson(jsonString, clazz);
  }

  public static <T> List<T> parseGenericList(final String json, final Class<T[]> clazz) {
    final T[] jsonToObject = new Gson().fromJson(json, clazz);
    return Arrays.asList(jsonToObject);
  }

}