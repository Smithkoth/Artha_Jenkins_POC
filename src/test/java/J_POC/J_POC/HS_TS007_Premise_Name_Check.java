package J_POC.J_POC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class HS_TS007_Premise_Name_Check 
{
	 @Test
	  public void HS_Premise_First_Name_Check_TC018() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where Premise_First_Name is null"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Premise_First_Name is Mandatory", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Premise_First_Name Check is PASSED", 0, t);
				  }
			  }
		  }
		  catch (ClassNotFoundException e1) 
		  {
				  // TODO Auto-generated catch block
				  e1.printStackTrace();
		  } 
	  }
	 @Test
	  public void HS_Premise_Last_Name_Check_TC019() throws SQLException 
	  {
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve","root","mysql");   
			  Statement stmt=con.createStatement();  
			  ResultSet rs=stmt.executeQuery("SELECT * FROM homeserve.transtopartner_mdu where Premise_Last_Name is null"); 
			  while (rs.next()) 
			  {
				  rs.last();
				  int t=rs.getRow();
				  if(t!=0)
				  {
					  Assert.assertEquals("Premise_Last_Name is Mandatory", 0, t);
				  }
				  else
				  {
					  Assert.assertEquals("Premise_Last_Name Check is PASSED", 0, t);
				  }
			  }
		  }
		  catch (ClassNotFoundException e1) 
		  {
				  // TODO Auto-generated catch block
				  e1.printStackTrace();
		  } 
	  }
}
