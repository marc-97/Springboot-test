package crm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @PostMapping("/customers")
  public Customer addCustomer(@RequestBody Customer newCustomer) {
    return newCustomer;
  }
}
