package CustomerService.Repository;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import CustomerService.Models.Customer;
public class TableCustomerController{
	private static TableCustomerController xGetInstance;
	private TableCustomerController()
	{
		
	}
	public static TableCustomerController vGetInstance()
	{
		if(xGetInstance == null)
			xGetInstance = new TableCustomerController();
		return xGetInstance;
	}
	
	public void vCreateTableCustomer()
	{
		Connection xConnection = DataBaseController.vGetInstance().connectionCreateConnectionToDataBase();
		Statement xStatement;
		
		try
		{  		
			xStatement = xConnection.createStatement();			
			ResultSet xResultSet = DataBaseController.vGetInstance().execQuery(Queries.strQueryCheckTableCustomerExist, xConnection);
			if(xResultSet != null)
			{
				int iCheckTableCustomerCount = 0;
				while (xResultSet.next())
				{	
					iCheckTableCustomerCount = Integer.parseInt(xResultSet.getString("COUNT(*)"));
				}
				if(iCheckTableCustomerCount == 0)
				{
					xStatement.executeUpdate(Queries.strQueryCreateDefaultTableCustomer);
				}
				else
				{
				}
			}
			else
			{
			}	
		} 
		catch (Exception e) 
		{
	    }		
		finally
		{		
			DataBaseController.vGetInstance().vCloseConnection(xConnection);
		}
	
	}
	public void vInsertCustomer(Customer xCustomer)
	{
		Connection xConnection = DataBaseController.vGetInstance().connectionCreateConnectionToDataBase();
		Statement xStatement;
		try
		{
			xStatement = xConnection.createStatement();			
			ResultSet xResultSet = DataBaseController.vGetInstance().execQuery(String.format(Queries.strQueryGetCustomer, xCustomer.getCustomerMail()), xConnection);
			if(xResultSet != null)
			{
				int iCheckTableCustomerCount = 0;
				while (xResultSet.next())
				{	
					iCheckTableCustomerCount = Integer.parseInt(xResultSet.getString("COUNT(*)"));
				}
				if(iCheckTableCustomerCount == 0)//new user
				{
					xStatement.executeUpdate(String.format(Queries.strInsertNewCustomer, xCustomer.getCustomerName(), xCustomer.getCustomerMail()));
				}
				else// same user
				{
					xStatement.executeUpdate(String.format(Queries.strSameCustomer, xCustomer.getCustomerMail()));

				}
			}
			else
			{
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
