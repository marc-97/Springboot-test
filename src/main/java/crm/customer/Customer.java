package crm.customer;

import static crm.util.Util.requireAllNonNull;

public class Customer {
  private final String firstName;
  private final String lastName;
  private final Email email;

  public Customer(String firstName, String lastName, Email email) {
    requireAllNonNull(firstName, lastName, email);
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public Email getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return String.format("%s %s", firstName, lastName);
  }
}
