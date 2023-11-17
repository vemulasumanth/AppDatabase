package org.easy.sumanth.model;

import org.easy.sumanth.dataconfig.DataBaseConfig;
import org.easy.sumanth.entity.Detail;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;;

public class Detailmodel {
	public List<Detail> listuser()
	{
		List<Detail> lu=new ArrayList<Detail>();
		Connection conn=DataBaseConfig.getConnection();
		Statement stmt=null;
		ResultSet rs=null;
		String query="select * from details";
		try {
		stmt=conn.createStatement();
		rs=stmt.executeQuery(query);
		while(rs.next())
		{
			lu.add(new Detail(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("email_id")));
		}
	}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lu;
		}
    public void addDetails(Detail newDetail)
    {
    	Connection conn=null;
    	PreparedStatement stmt=null;
    	try {
    		conn=DataBaseConfig.getConnection();
        	String username=newDetail.getUser_name();
        	String emailid=newDetail.getEmail_id();
        	String query="insert into details(user_name,email_id) values(?,?)";
			stmt=conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, emailid);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public void updateDetails(Detail updateDetail)
    {
    	Connection conn=null;
    	PreparedStatement stmt=null;
    	try {
    		conn=DataBaseConfig.getConnection();
        	int userId=updateDetail.getUser_id();
        	String username=updateDetail.getUser_name();
        	String emailid=updateDetail.getEmail_id();
        	String query="update details set username=?,email_id=? where user_id=?";
			stmt=conn.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, emailid);
			stmt.setInt(3, userId);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void deleteDetails(int userId)
    {
    	Connection conn=null;
    	PreparedStatement stmt=null;
    	try {
    		conn=DataBaseConfig.getConnection();
        	String query="delete from details where user_id=?";
			stmt=conn.prepareStatement(query);
			stmt.setInt(1, userId);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
