package CustomerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import CustomerService.Models.Customer;
import CustomerService.Repository.DataBaseController;
import CustomerService.Repository.TableCustomerController;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		DataBaseController.vGetInstance().vCreateAllTables();
	}

}
