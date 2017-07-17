package J_POC.J_POC;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;

public class HS_TS008_AEPCustomer_Details_Check 
{
	@Test
	public void HS_AEPCustomer_FirstName_Check_TC020() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT FirstName,UID FROM homeserve.aepcustomer");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPCustomer20150801");
			int c = 0;
			List<String> exceldata=new ArrayList<String>();
			List<String> dbdata=new ArrayList<String>();
			for (int i = 1; i < s.getRows(); i++) 
			{
				exceldata.add(s.getCell(0, i).getContents());
			}
			while (rs.next()) 
			{
				dbdata.add(rs.getString("FirstName"));
			}
			for(int i=0;i<exceldata.size();i++){
				if(exceldata.get(i).equalsIgnoreCase(dbdata.get(i)))
				{
					Assert.assertEquals("AEP Partner First name Check is as Expected",exceldata.get(i), dbdata.get(i));
				}
				else
				{
					Assert.assertEquals("AEP Partner First name Check is Failed",exceldata.get(i), dbdata.get(i));
				}
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public void HS_AEPCustomer_LastName_Check_TC021() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT LastName,UID FROM homeserve.aepcustomer");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPCustomer20150801");
			List<String> exceldata=new ArrayList<String>();
			List<String> dbdata=new ArrayList<String>();
			int c=0;
			for (int i = 1; i < s.getRows(); i++) 
			{
				if(s.getCell(2, i).getContents().equalsIgnoreCase(""))
				{
					exceldata.add(s.getCell(0, i).getContents());
				}
				else
				{
					exceldata.add(s.getCell(2, i).getContents());
				}
			}
			while (rs.next()) 
			{
				dbdata.add(rs.getString("LastName"));
			}
			for(int i=0;i<exceldata.size();i++)
			  {
				if(exceldata.get(i).equalsIgnoreCase(dbdata.get(i)))
				{
					Assert.assertEquals("AEP Partner Last name Check is as Expected",exceldata.get(i), dbdata.get(i));
				}
				else
				{
					Assert.assertEquals("AEP Partner Last name Check is Failed",exceldata.get(i), dbdata.get(i));
					System.out.println(c);
				}
			}
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test(priority=2)
	public void HS_AEPCustomer_MailingAddressState_Check_TC022() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT distinct MailingAddressState as MailingAddressState FROM homeserve.aepcustomer");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPCustomer20150801");
			List<String> exceldata=new ArrayList<String>();
			List<String> dbdata=new ArrayList<String>();
			exceldata.add("AA");
			exceldata.add("AL");
			exceldata.add("AK");
			exceldata.add("AS");
			exceldata.add("AZ");
			exceldata.add("AR");
			exceldata.add("CA");
			exceldata.add("CO");
			exceldata.add("CT");
			exceldata.add("DE");
			exceldata.add("DC");
			exceldata.add("FM");
			exceldata.add("FL");
			exceldata.add("GA");
			exceldata.add("GU");
			exceldata.add("HI");
			exceldata.add("ID");
			exceldata.add("IL");
			exceldata.add("IN");
			exceldata.add("IA");
			exceldata.add("KS");
			exceldata.add("KY");
			exceldata.add("LA");
			exceldata.add("ME");
			exceldata.add("MH");
			exceldata.add("MD");
			exceldata.add("MA");
			exceldata.add("MI");
			exceldata.add("MN");
			exceldata.add("MS");
			exceldata.add("MO");
			exceldata.add("MT");
			exceldata.add("NE");
			exceldata.add("NV");
			exceldata.add("NH");
			exceldata.add("NJ");
			exceldata.add("NM");
			exceldata.add("NY");
			exceldata.add("NC");
			exceldata.add("ND");
			exceldata.add("MP");
			exceldata.add("OH");
			exceldata.add("OK");
			exceldata.add("OR");
			exceldata.add("PW");
			exceldata.add("PA");
			exceldata.add("PR");
			exceldata.add("RI");
			exceldata.add("SC");
			exceldata.add("SD");
			exceldata.add("TN");
			exceldata.add("TX");
			exceldata.add("UT");
			exceldata.add("VT");
			exceldata.add("VI");
			exceldata.add("VA");
			exceldata.add("WA");
			exceldata.add("WV");
			exceldata.add("WI");
			exceldata.add("WY");
				while (rs.next()) 
				{
					dbdata.add(rs.getString("MailingAddressState"));
				}
				for(String exdata:exceldata)
				{
					for(String dbdd:dbdata)
					{
						if(exdata.equalsIgnoreCase(dbdd))
						{
							Reporter.log("Mailing Address State Check is as Expected");
							//Assert.assertEquals("Mailing Address State Check is as Expected",exdata,dbdd);
						}
						else
						{
							Reporter.log("Mailing Address State Check is Failed");
							//Assert.assertEquals("Mailing Address State Check is Failed",exdata,dbdd);
						}
					}
				}
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test(priority=3)
	public void HS_AEPCustomer_PremisesAddressZipPlus4_Check_TC023() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PremisesAddressZipPlus4 FROM homeserve.aepcustomer");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPCustomer20150801");
			List<String> exceldata=new ArrayList<String>();
			List<String> dbdata=new ArrayList<String>();
			for (int i = 1; i < s.getRows(); i++) 
			{
				exceldata.add(s.getCell(12, i).getContents());
			}
			while (rs.next()) 
			{
				dbdata.add(rs.getString("PremisesAddressZipPlus4"));
			}
			for(int i=0;i<exceldata.size();i++)
			{
				if(exceldata.get(i).length()==5)
				{
					Assert.assertEquals("AEP Partner Premises Address Zip Plus4 Check is as Expected",exceldata.get(i), dbdata.get(i));
				}
				else
				{
					boolean Z=dbdata.get(i).matches("[0-9]{5}_[0-9]{4}");
					  if(Z==true)
					  {
						  Assert.assertEquals("AEP Partner Premises Address Zip Plus4 Pattern Check is as Expected", Z,true);
					  }
					  else
					  {
						  Assert.assertEquals("AEP Partner Premises Address Zip Plus4 Pattern Check is Failed", Z,true);
					  }
				}
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test(priority=4)
	public void HS_AEPCustomer_UniqueID_Check_TC024() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT UniqueID FROM homeserve.aepcustomer");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPCustomer20150801");
			List<String> exceldata=new ArrayList<String>();
			List<String> dbdata=new ArrayList<String>();
			for (int i = 1; i < s.getRows(); i++) 
			{
				exceldata.add(s.getCell(14, i).getContents());
			}
			while (rs.next()) 
			{
				dbdata.add(rs.getString("UniqueID"));
			}
			for(int i=0;i<exceldata.size();i++)
			{
					if(exceldata.get(i).equalsIgnoreCase(dbdata.get(i)))
					{
						Assert.assertEquals("AEP Partner User ID Check is as Expected",exceldata.get(i), dbdata.get(i));
					}
					else
					{
						Assert.assertEquals("AEP Partner User ID Check is Failed",exceldata.get(i), dbdata.get(i));
					}
					boolean Z=dbdata.get(i).matches("[a-zA-Z]{4}[0-9]{9}");
					  if(Z==true)
					  {
						  Assert.assertEquals("AEP Partner User ID Pattern Check is as Expected", Z,true);
					  }
					  else
					  {
						  Assert.assertEquals("AEP Partner User ID Pattern Check is Failed",Z,true);
					  }
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
}