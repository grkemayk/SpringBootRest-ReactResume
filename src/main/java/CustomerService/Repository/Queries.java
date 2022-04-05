package CustomerService.Repository;

public class Queries {
	protected static String strQueryCheckTableCustomerExist = "SELECT COUNT(*) FROM sqlite_master WHERE TYPE='table' AND NAME='TableCustomer'";
	protected static String strQueryCreateDefaultTableCustomer = 			
			"CREATE TABLE if not exists TableCustomer ("+"Id INTEGER primary key,\n"				
			+ " CustomerName TEXT,\n"
			+ " CustomerMail TEXT,\n"
			+ " EntryCount INTEGER DEFAULT 1,\n"
			+ " UNIQUE(CustomerMail)"
			+" )";
	protected static String strQueryGetCustomer = "SELECT COUNT(*),* FROM TableCustomer WHERE CustomerMail='%s'";
	protected static String strInsertNewCustomer = "INSERT INTO TableCustomer (CustomerName, CustomerMail) VALUES('%s', '%s')";
	protected static String strSameCustomer = "UPDATE TableCustomer SET EntryCount = EntryCount+1 WHERE CustomerMail='%s'";			
}
