package crm.util;

import static java.util.Objects.requireNonNull;

public class Util {

  public static void checkArgument(boolean condition, String errorMessage) {
    if (!condition) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  public static void requireAllNonNull(Object... objs) {
    for (Object obj : objs) {
      requireNonNull(obj);
    }
  }
}
