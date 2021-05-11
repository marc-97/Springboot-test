package crm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @PostMapping("/customers")
  public Customer addCustomer(@RequestBody Customer newCustomer) {
    return newCustomer;
  }
}
