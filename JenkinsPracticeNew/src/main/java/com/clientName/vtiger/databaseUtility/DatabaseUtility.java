package com.clientName.vtiger.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.clientName.vtiger.generic.fileUtility.FileUtility;
import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection con;
	Statement stat;
	//get connection with parameter....
	public void getDbConnection(String url, String username, String password) throws SQLException
	{
		try {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(url, username, password);
		stat=con.createStatement();
		}
		catch (Exception e) {
		}
	}
	
	//get connection without parameter......
	public void getDbConnection(){
		try{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			FileUtility fu=new FileUtility();
			String dbUrl = fu.getDataFromProperties("dbURL");
			String dbUsername = fu.getDataFromProperties("dbUsername");
			String dbPassword = fu.getDataFromProperties("dbPassword");
			con=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			stat=con.createStatement();
		}
		catch (Exception e) {
		}
	}
	
	//close connection....
	public void closeConnection(){
		try{
			con.close();
		}
		catch (Exception e) {
		}
	}
	
	//execute select query....
	public ResultSet executeSelectQuery(String query)
	{
		ResultSet result=null;
		try {
			Statement stat=con.createStatement();
			result=stat.executeQuery(query);
		}
		catch (Exception e) {
		}
		return result;
	}
	
	//execute non select query....
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		try {
			Statement stat=con.createStatement();
			result=stat.executeUpdate(query);
			}
		catch (Exception e) {
			}
		return result;
	}
}
