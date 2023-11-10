<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Employe" %>
<%@ page import="com.tap.dao.EmployeBoImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee details</title>
<style>
        table {
            border-collapse: collapse;
            width: 50%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: yellow;
        }
    </style>
</head>
				<body>
				  <h2>Employee details</h2>
				  <table>
				  <th>Id</th>
				  <th>Name</th>
				  <th>Email</th>
				  <th>Department</th>
				  <th>Salary</th>
				  <%
				List<Employe> emp=new EmployeBoImpl().getAll();
				  
				  for(Employe empl:emp){
				  
				  %>
				  <tr>
				    <td><%=empl.getId() %></td>
				    <td><%= empl.getName() %></td>
				    <td><%= empl.getEmail() %></td>
				    <td><%= empl.getDepartment() %></td>
				    <td><%= empl.getSalary() %></td>
				    <td>
				    <a href="update.html"><button>update</button></a>
				    
				     </td>
				  <%
				  }
				  %>
				  </table>
				  <a href="rigister.html"><button>rigister</button></a>
				
				</body>
</html>