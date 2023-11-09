package com.tap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tap.model.Employe;

public class EmployeBoImpl implements EmployeBo {
	
private static Connection conection=null;
private static PreparedStatement pst=null;

		
       
       public EmployeBoImpl() {
    	   try {
    	   Class.forName("com.mysql.cj.jdbc.Driver");
    	   conection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Management","root","admin");
    	   
    	   }
    	   catch(SQLException |ClassNotFoundException e1) {
    			e1.printStackTrace();
    			
    		}
	}


	
	public int save(Employe e) {
		String INSERT_QUERY="INSERT into `employe`(id,name,email,department,salary) values(?,?,?,?,?)";
		try {
		pst=conection.prepareStatement(INSERT_QUERY);
		pst.setInt(1, e.getId());
		pst.setString(2, e.getName());
		pst.setString(3, e.getEmail());
		pst.setString(4, e.getDepartment());
		pst.setInt(5, e.getSalary());
		
		
		return pst.executeUpdate();
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}


	public int update(Employe e) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int delete(Employe e) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public Employe get(int id) {
		
		return null;
	}




}


