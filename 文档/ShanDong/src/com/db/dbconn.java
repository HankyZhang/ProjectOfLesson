package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconn {
	private String driverName = "com.mysql.jdbc.Driver"; 
	private String url = "jdbc:mysql://127.0.0.1/mydatabase111?useUnicode=true&characterEncoding=UTF-8";
	private String user = "root";
	private String password = "root";
	public void setDriverName(String newDriverName) 
	{
        this.driverName = newDriverName;
    }
    public String getDriverName()
    {
        return driverName;
    }
	public void setUrl(String newUrl) 
	{
	    this.url = newUrl;
	}
	public String getUrl() 
	{
		return url;
	}
	public void setUser(String newUser) 
	{
	    this.user = newUser;
	}
	public String getUser() 
	{
	    return user;
	}
	public void setPassword(String newPassword)
	{
	   this.password = newPassword;
	}
	public String getPassword() 
	{
	   return password;
	}
	public Connection getConnection() 
	{
	     try
	     {
	         Class.forName(driverName);
	         return DriverManager.getConnection(url, user, password);
	     }
	     catch (Exception e) 
	     {
	            e.printStackTrace();
	            return null;
       	 }
   	}
}