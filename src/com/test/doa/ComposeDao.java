package com.test.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComposeDao {

	public int compose(String to,String from,String sub,String msg)
	{
		int x=0 ;
		try(Connection con= new RegisterDao().startConnection())
		{
	PreparedStatement ps=con.prepareStatement("insert into composemail(senderid,receiverid,subject,message)values(?,?,?,?)");
	ps.setString(1, from);
	ps.setString(2, to);
	ps.setString(3, sub);
	ps.setString(4, msg);
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
