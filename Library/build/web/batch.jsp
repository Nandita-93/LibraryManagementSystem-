<%-- 
    Document   : batch
    Created on : Oct 27, 2015, 7:20:05 PM
    Author     : nanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor = "grey">
    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>
      <%@ page language="java" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.lang.*"%>
<%@ page import =" java.util.Date" %>
<%@ page import = "java.text.DateFormat" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import ="java.util.Calendar" %>
<%@ page import= "java.util.concurrent.TimeUnit"%>
<%  
try
{
String QueryString;
double fine=0;  
Connection connection = null;
Statement statement = null;
ResultSet rs = null, rs1=null;
Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","nandy123");  
statement = connection.createStatement();
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
Date date = new Date();
//out.println(date);
Date d = dateFormat.parse(dateFormat.format(date));
QueryString = "select loan_id,  Due_date from book_loans where Due_date IS NOT NULL; ";
PreparedStatement pr1 = (PreparedStatement) connection.prepareStatement(QueryString);
rs = pr1.executeQuery(QueryString);
while(rs.next()){
int loanid = Integer.parseInt(rs.getString(1));
Date duedate=rs.getDate(2);
long diff= d.getTime() - duedate.getTime();
//out.println("DIFF"+TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
long time = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
int x = d.compareTo(duedate);
//out.println(time);
if(x==1)
      fine= 0.25*time; 
else
      fine = 0;

String sq="insert into fine (loan_id, fine_amt)values ("+loanid+","+fine+");";
PreparedStatement pr = (PreparedStatement) connection.prepareStatement(sq);
pr.executeUpdate();
}
out.println("The fine table has been update as per the newly recorded book loans table");
}
catch(Exception e)
{
out.println(e);
}
%>
        <h3><a href='index.jsp'>Home</a></h3>
    </body>
</html>
