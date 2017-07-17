package J_POC.J_POC;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.Test;

public class HS_TS010_PaymentsFromPartner_Check 
{
	@Test
	public void HS_SJPayments_AccountNumber_Check_TC028() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Partner_Account_Number FROM homeserve.sjpaymentsfrompartner where Partner_Account_Number like '0%'");
			  ResultSetMetaData rsmd = rs.getMetaData();
			  int c= rsmd.getColumnCount();
			  if(c!=0)
			  {
				  Assert.assertEquals("Payments From Partner Account Number check is as Expected ",0, c);
			  }
			  else
			  {
				  Assert.assertEquals("Payments From Partner Account Number can not be All Zeros(0) Reason as ",0, c);
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}

	@Test
	public void HS_SJPayments_ChargeType_Check_TC029() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM homeserve.sjpaymentsfrompartner where Partner_ChargeType not in('J','N')");
			  while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  Assert.assertEquals("Payments From Partner Charge Type Check is as Expected ",0, k);	
				  }
				  else
				  {
					  Assert.assertEquals("Payments From Partner Charge Type Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number")+" Reason as ",0, k);	
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	
	@Test
	public void HS_SJPayments_Invoice_Number_Check_TC030() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM homeserve.sjpaymentsfrompartner where HS_Invoice_Number like '0%'");
			while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  Assert.assertEquals("Payments From Partner Charge Type Check is as Expected ",0, k);	
				  }
				  else
				  {
					  Assert.assertEquals("Payments From Partner Charge Type Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number")+" Reason as ",0, k);	
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test
	public void HS_SJPayments_Transaction_Amount_Check_TC031() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM homeserve.sjpaymentsfrompartner where Partner_Transaction_Amount=0");
			while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  Assert.assertEquals("Payments From Partner Partner Transaction Amount Check is as Expected ",0, k);	
				  }
				  else
				  {
					  Assert.assertEquals("Payments From Partner Partner Transaction Amount Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number")+" Amount value not zero, but we got count as ",0, k);	
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	
	@Test
	public void HS_SJPayments_Partner_ChargeSign_Check_TC032() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM homeserve.sjpaymentsfrompartner where Partner_ChargeType='N' and Partner_ChargeSign!='D' and Partner_ChargeSign in('C','D')");
			while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  Assert.assertEquals("Payments From Partner Charge Sign Check is as Expected ",0, k);	
				  }
				  else
				  {
					  Assert.assertEquals("Payments From Partner Charge Sign Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number"),0, k);	
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	
	@Test
	public void HS_SJPayments_Partner_Record_Type_Check_TC033() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM homeserve.sjpaymentsfrompartner where (Partner_ChargeType='N' and Partner_ChargeSign='D' and Record_Type!='Partner_Payment_Debit_R5') or (Partner_ChargeType='J' and Partner_ChargeSign='D' and Record_Type!='Partner_Payment_Debit_R6') or (Partner_ChargeType='J' and Partner_ChargeSign='C' and Record_Type!='Partner_Payment_Credit_R5')");
			while(rs.next())
			  {
				  rs.last();
				  int k=rs.getRow();
				  if(k==0)
				  {
					  Assert.assertEquals("Payments From Partner Record Type Check is as Expected ",0, k);	
				  }
				  else
				  {
					  Assert.assertEquals("Payments From Partner Record Type Check is Failed at Partner_Account_Number= "+rs.getString("Partner_Account_Number"),0, k);	
				  }
			  }
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
}
