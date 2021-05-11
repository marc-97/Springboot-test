package crm;

import org.springframework.data.repository.CrudRepository;
import com.example.accessingdatamysql.User;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
