package crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @Autowired
  private CustomerRepository customerRepository;

  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping("/customers")
  public @ResponseBody Customer addCustomer(@RequestBody Customer newCustomer) {
    return customerRepository.save(newCustomer);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping(path="/customers")
  public @ResponseBody Iterable<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @CrossOrigin(origins = "http://localhost:3000")
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

  @CrossOrigin(origins = "http://localhost:3000")
  @DeleteMapping("/customers/{id}")
  public void deleteCustomer(@PathVariable(value = "id") Integer id) {
    customerRepository.deleteById(id);
  }

}
