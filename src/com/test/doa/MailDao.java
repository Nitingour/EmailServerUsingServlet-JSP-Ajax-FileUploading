package com.test.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MailDao {


	public int deleteMail(String id)
	{
		int x=0 ;
		try(Connection con= new RegisterDao().startConnection())
		{
	PreparedStatement ps=con.prepareStatement("delete from composemail where subject=?");
	ps.setString(1, id);
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
