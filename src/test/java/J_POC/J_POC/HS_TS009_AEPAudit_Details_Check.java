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
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class HS_TS009_AEPAudit_Details_Check 
{
	@Test
	public void HS_AEPAudit_Date_Check_TC025() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM homeserve.aepaudit where datediff(ExpDate,EffDate)<0");
			while (rs.next()) 
			{
			   	int t=rs.getRow();
				if(rs.getRow()<0)
				{
					Assert.assertEquals("AEPAudit Date Check is as Expected at UniqueID= "+rs.getString("UniqueID")+" Reason as ",0, t);
				}
				else
				{
					Assert.assertEquals("AEPAudit Date Check is Failed at UniqueID= "+rs.getString("UniqueID")+" Reason as ",0, t);					
				}
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	@Test(priority=1)
	public void HS_AEPAudit_ProductCodes_Null_Check_TC026() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM homeserve.aepaudit where ProdCodes is null");
			while (rs.next()) 
			{
			   	int t=rs.getRow();
				if(rs.getRow()<0)
				{
					Assert.assertEquals("AEPAudit Product Codes Check is as Expected at UniqueID= "+rs.getString("UniqueID")+" Reason as ",0, t);
				}
				else
				{
					Assert.assertEquals("AEPAudit Product Codes Check is Failed at UniqueID= "+rs.getString("UniqueID")+" Reason as ",0, t);					
				}
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}
	/*
	@Test(priority=2)
	public void HS_AEPAudit_ProductCodes_Count_Check_TC027() throws SQLException,BiffException, IOException 
	{
		Workbook w;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/homeserve", "root", "mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM homeserve.aepaudit where ProdCodes is null");
			w = Workbook.getWorkbook(new File("C:\\Artha\\TransToPartner_MDU_11042015_002020.xls"));
			Sheet s = w.getSheet("AEPAudit");
			List<String> exceldata=new ArrayList<String>();
			for (int i = 1; i < s.getRows(); i++) 
			{
				exceldata.add(s.getCell(1, i).getContents());
				
			}
			for (int j=1;j<exceldata.size();j++)
			{
				if(exceldata.get(j).contains(","))
				{
					List<String> items = Arrays.asList(exceldata.get(j).split(","));
					System.out.println("ssssssssssssssssss:"+items.get(j));
					
				}
				else
				{
					System.out.println(exceldata.get(j));
				}
			}
			
			while (rs.next()) 
			{
			   	int t=rs.getRow();
				if(rs.getRow()<0)
				{
					Assert.assertEquals("AEPAudit Product Codes Check is as Expected at UniqueID= "+rs.getString("UniqueID")+" Reason as ",0, t);
				}
				else
				{
					Assert.assertEquals("AEPAudit Product Codes Check is Failed at UniqueID= "+rs.getString("UniqueID")+" Reason as ",0, t);					
				}
			}
		}
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
	}*/
}
