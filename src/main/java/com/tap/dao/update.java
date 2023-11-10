package com.tap.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.model.Employe;


@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private PrintWriter out=null;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("username");
		String email=request.getParameter("useremail");
		String department=request.getParameter("userdepartment");
		int salary=Integer.parseInt(request.getParameter("usersalary"));
		
		Employe e=new Employe(id,name,email,department,salary);
		
		EmployeBoImpl empbo=new EmployeBoImpl();
		
		
		
		int i=empbo.update(e);
		out=response.getWriter();
		response.setContentType("text/html");
		if(i>0) {
		out.print("updation successfull");	
		}
		else {
			out.print("failed");
		}
		
	}

}
