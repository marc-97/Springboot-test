package crm.customer;

import static java.util.Objects.requireNonNull;
import static crm.util.Util.checkArgument;

public class Email {

  public static final String INVALID_MESSAGE = "Email is invalid.";
  public static final String VALID_REGEX = "^(.+)@(.+)$";

  private final String value;

  public Email(String email) {
    requireNonNull(email);
    checkArgument(isValidEmail(email), INVALID_MESSAGE);
    value = email;
  }

  public boolean isValidEmail(String s) {
    return s.matches(VALID_REGEX);
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}
