package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAOImpl implements UserDAO {

	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();

		this.conn = conn;
	}

	@Override
	public boolean userRegister(User us) {
		boolean f = false;
		try {
			String sql = "INSERT INTO user(name, email, phno, password, adress, landmark, city, state, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhno());
			ps.setString(4, us.getPassword());
			ps.setString(5, us.getAdress());
			ps.setString(6, us.getLandmark());
			ps.setString(7, us.getCity());
			ps.setString(8, us.getState());
			ps.setString(9, us.getPincode());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public User login(String email, String password) {
	    User user = null;

	    try {
	        String sql = "SELECT * FROM user WHERE email=? AND password=?";
	        
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, email);
	        ps.setString(2, password);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) { 
	            user = new User(
	                rs.getInt(1), 
	                rs.getString(2), 	              
	                rs.getString(3), 
	                rs.getString(4), 
	                rs.getString(5), 
	                rs.getString(6), 
	                rs.getString(7), 
	                rs.getString(8), 
	                rs.getString(9), 
	                rs.getString(10) 
	            ); 
	        }
	        
	        ps.close();
	        rs.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;
	}

	@Override
	public boolean checkPassword(int id,String ps) {
		boolean f=false;
		
		try {
			
			String sql = "SELECT * FROM user WHERE id=? AND password=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2,ps);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				
				f=true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean updateProfile(User us) {
		boolean f = false;
		try {
			String sql = "UPDATE user SET name=?, email=?, phno=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhno());
			ps.setInt(4, us.getId());
			
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}


}
