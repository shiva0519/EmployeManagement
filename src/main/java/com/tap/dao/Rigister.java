package com.tap.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.model.Employe;

@WebServlet("/rigister")
public class Rigister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static PrintWriter out=null;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("username");
		String email=request.getParameter("useremail");
		String department=request.getParameter("userDepartment");
		int salary=Integer.parseInt(request.getParameter("userSalary"));
		 
		Employe e=new Employe(id,name,email,department,salary);
		EmployeBoImpl e1=new EmployeBoImpl();
		out=response.getWriter();
		response.setContentType("text/html");
		
	
			int i=e1.save(e);
			if(i>0) {
				out.print("<h1>INSERTED SUCCESSFULLY</h1>");
			}
			else {
				out.print("<h1>INSERTED UNSUCCESSFULLY</h1>");
			}
		}
		
			
		}
		
		
		
	
	


