package com.test.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	
	public Connection startConnection() throws SQLException, ClassNotFoundException
	{
		Connection con=null;
	   
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	    
           return con;
	}
	

	public int register(String name,String email,String password)
	{
		int x=0 ;
		try(Connection con= startConnection())
		{
	PreparedStatement ps=con.prepareStatement("insert into userregister(name,emailid,password) values(?,?,?)");
	ps.setString(1, name);
	ps.setString(2, email);
	ps.setString(3, password);
	 x= ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	public int saveOTP(String email,String otp)
	{
		int x=0 ;
		try(Connection con= startConnection())
		{
	PreparedStatement ps=con.prepareStatement("update userregister set otp=? where emailid=?");
	ps.setString(1, otp);
	ps.setString(2, email);
	 x= ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	
}
