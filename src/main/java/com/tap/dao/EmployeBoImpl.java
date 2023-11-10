package com.tap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.model.Employe;

public class EmployeBoImpl implements EmployeBo {
	
private static Connection conection=null;
private static PreparedStatement pst=null;
private static Statement statement=null;
private static ResultSet res=null;
static ArrayList<Employe> employeelist=null;
       
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
		try {
			String UPDATE_QUERY="UPDATE `employe` SET name = ?,email =?,department = ?,salary = ? WHERE id=?";
		pst=conection.prepareStatement(UPDATE_QUERY);
		pst.setString(1, e.getName());
		pst.setString(2, e.getEmail());
		pst.setString(3, e.getDepartment());
		pst.setInt(4, e.getSalary());
		pst.setInt(5,e.getId());
		
		return pst.executeUpdate();
		
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
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
	public List<Employe>getAll(){
		String GET_ALL="SELECT* from Employe";
		employeelist=new ArrayList<Employe>();
		try {
		statement=conection.createStatement();
		res=statement.executeQuery(GET_ALL);
		while(res.next()) {
			int id=res.getInt("id");
			String name=res.getString("name");
			String email=res.getString("email");
			String department=res.getString("department");
			int salary=res.getInt("salary");
			Employe e=new Employe(id,name,email,department,salary);
			employeelist.add(e);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return employeelist;
	}




}


