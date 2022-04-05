package CustomerService.Models;



public class Customer {
	public Customer(String CustomerName,String CustomerMail)
	{
		this.CustomerName = CustomerName;
		this.CustomerMail = CustomerMail;
	}
	
	@Override
	public String toString() {
		return "Customer [CustomerMail=" + CustomerMail + ", CustomerName=" + CustomerName + "]";
	}


	private String CustomerMail;

	private String CustomerName;

	public String getCustomerMail() {
		return CustomerMail;
	}

	public void setCustomerMail(String customerMail) {
		CustomerMail = customerMail;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	

	
	

}
