package CustomerService.Repository;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseController {
	public DataBaseController()
	{
		vCreateSourceFolder();
	}
	private static DataBaseController xGetInstance;

	public static DataBaseController vGetInstance()
	{	
		if(xGetInstance == null)
			xGetInstance = new DataBaseController();
		return xGetInstance;
	}
	private void vCreateSourceFolder()
	{
		try
		{
			Files.createDirectories(Paths.get("C:\\CustomerList"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void vCreateAllTables()
	{
		try
		{
			TableCustomerController.vGetInstance().vCreateTableCustomer(); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void vCloseConnection(Connection xConnection)
	{
		try 
		{
			if(xConnection != null)
				xConnection.close();
		} 
		catch (SQLException e) 
		{

		}
	}
	public Connection connectionCreateConnectionToDataBase()
	{
		Connection xConnection;
		try
		{			
			xConnection = null;
			Class.forName("org.sqlite.JDBC");			
	        xConnection = DriverManager.getConnection("jdbc:sqlite:C:\\CustomerList\\Customer.db");
	        return xConnection;
   
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;

	}
	public ResultSet execQuery(String strQuery, Connection xConnection)
	{
		Statement xStatement;
		
		ResultSet xResultSet;
		xResultSet = null;

		try
		{	
			xStatement = xConnection.createStatement();
			xResultSet = xStatement.executeQuery(strQuery);			
			return xResultSet;
		} 
		catch (Exception e) 
		{
		}	
		return null;
		
	}
	public void execNonQuery(String strQuery)
	{	
		Connection xConnection = connectionCreateConnectionToDataBase();
		Statement xStatement;
		try
		{	
			xStatement = xConnection.createStatement();
			xStatement.executeUpdate(strQuery);	
		} 		
		catch(Exception e)
		{
		}
		
		finally
		{
			vCloseConnection(xConnection);
		}
	}

}
