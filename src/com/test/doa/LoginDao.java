package com.test.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//this is login doa
public class LoginDao {
//LoginDao(String s){}
	
	public int checkLogin(String email,String password)
	{
		int x=0;
		try(Connection con= new RegisterDao().startConnection())
		{
			System.out.println(email +""+password);
			
	PreparedStatement ps=con.prepareStatement("select * from userregister where emailid=? and password=?");
	ps.setString(1, email);
	ps.setString(2, password);
	System.out.println(ps);
	 ResultSet rs=ps.executeQuery();
	 if(rs.next())
		 x=1;
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
