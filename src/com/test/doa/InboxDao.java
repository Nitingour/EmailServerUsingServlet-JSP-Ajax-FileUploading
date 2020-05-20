package com.test.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.test.utility.InboxBean;

public class InboxDao {
	public  ArrayList<InboxBean>  getInboxMail(String id)
	{
		 ArrayList<InboxBean> list=new ArrayList<>();
		 try(Connection con= new RegisterDao().startConnection())
		{
			 PreparedStatement ps=null;
			if(id.equals("All"))
				ps=con.prepareStatement("select * from composemail");
			else 
			{	ps=con.prepareStatement("select * from composemail where subject like ? or  message like ? ");
			    ps.setString(1, "%"+id+"%");
			    ps.setString(2, "%"+id+"%");
			 
			}			
			ResultSet rs=ps.executeQuery();
	
	
	 while(rs.next())
	 {
	     InboxBean i=new InboxBean();
	     i.setSenderid(rs.getString("senderid"));
	     i.setRecieverid(rs.getString("RECEIVERID"));
	     i.setSubject(rs.getString("subject"));
	     i.setMessage(rs.getString("message"));
	     i.setDatetime(rs.getString("maildate"));
	     
	     list.add(i);
		 
	 }
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		  }
		return list;
	}


}
