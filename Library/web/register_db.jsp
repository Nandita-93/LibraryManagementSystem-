<%-- 
    Document   : register_db
    Created on : Oct 25, 2015, 2:35:42 AM
    Author     : nanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body bgcolor="grey">
        <CENTER><br><h1>DALLAS CITY LIBRARY</h1>
<%@ page language="java" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.lang.*"%>
<%@ page import ="java.util.Date" %>
<%@ page import ="java.text.DateFormat" %>
<%@ page import ="java.text.SimpleDateFormat" %>
<%@ page import ="java.util.Calendar" %>
<%@ page import ="java.lang.System" %>       
    <body>
    <center>
<%
String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
String email = request.getParameter("email");
String address = request.getParameter("address");
String city = request.getParameter("city");
String state = request.getParameter("state");
String num = request.getParameter("num");

try{
Connection connection = null;
Statement statement = null;
ResultSet rs=null;
Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","nandy123"); 
statement = connection.createStatement();
String sql="insert into borrower(fname,lname,email,address, city, state, phone) values('"+fname+"','"+lname+"','"+email+"','"+address+"','"+city+"','"+state+"','"+num+"');";
String sql1 = "select card_no from borrower where email = '"+email+"';";
String sql2 = "select card_no from borrower where email = '"+email+"';";
PreparedStatement pr2 = (PreparedStatement) connection.prepareStatement(sql2);
rs = pr2.executeQuery(sql2);
if(rs.next())
{
    out.println("You have already been registered!");
}
else{
PreparedStatement pr = (PreparedStatement) connection.prepareStatement(sql);
pr.executeUpdate(sql);

PreparedStatement pr1 = (PreparedStatement) connection.prepareStatement(sql1);
rs = pr1.executeQuery(sql1);
out.println("Congratulations! You have successfully registered!Your card number is");

if(rs.next()) {%>
<%=rs.getString(1)%>
<h3>Use this number to borrow and return books</h3>
<%
}
}
}
catch(Exception e)
{ System.out.println(e);
}
%>

<h3><a href="search.jsp">Search for books</a></h3>        
    </center>
    </body>
</html>
