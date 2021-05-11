package crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
public class MainController {

  @Autowired
  private CustomerRepository customerRepository;

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @PostMapping("/customers")
  public @ResponseBody Customer addCustomer(@RequestBody Customer newCustomer) {
    return customerRepository.save(newCustomer);
  }

  @GetMapping(path="/customers")
  public @ResponseBody Iterable<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @PutMapping("/customers/{id}")
  public @ResponseBody Customer updateCustomer(@PathVariable(value = "id") Integer id, @RequestBody Customer updatedCustomer) {
    return customerRepository.findById(id)
        .map(customer -> {
          customer.setFirstName(updatedCustomer.getFirstName());
          customer.setLastName(updatedCustomer.getLastName());
          customer.setEmail(updatedCustomer.getEmail());
          return customerRepository.save(customer);
        }).orElse(new Customer());
  }

  @DeleteMapping("/customers/{id}")
  public void deleteCustomer(@PathVariable(value = "id") Integer id) {
    customerRepository.deleteById(id);
  }

}
