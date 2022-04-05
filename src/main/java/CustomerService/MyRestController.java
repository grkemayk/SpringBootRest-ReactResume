package CustomerService;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import CustomerService.Models.Customer;
import CustomerService.Repository.TableCustomerController;
@RestController
public class MyRestController {
	
	
	
	@RequestMapping(value="/NewCustomer/{CustomerName}/{CustomerMail}", method = RequestMethod.GET)
	private void vNewCustomerr(@PathVariable(value="CustomerName") String CustomerName, @PathVariable(value="CustomerMail") String CustomerMail)
	{
		Customer xCustomer = new Customer(CustomerName, CustomerMail);
		TableCustomerController.vGetInstance().vInsertCustomer(xCustomer);
	}
	

}