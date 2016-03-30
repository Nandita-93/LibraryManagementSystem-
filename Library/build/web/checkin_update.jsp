<%-- 
    Document   : checkin_update
    Created on : Oct 25, 2015, 6:09:15 PM
    Author     : nanda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <body bgcolor = "grey">
    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>
<center><h1>CHECK IN BOOKS</h1>
<%@ page language="java" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.lang.*"%>
<%@ page import =" java.util.Date" %>
<%@ page import = "java.text.DateFormat" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import ="java.util.Calendar" %>
<%@ page import= "java.util.concurrent.TimeUnit"%>
<TABLE cellpadding="15" border="1" style="background-color: #ffffcd;"> 

<%  
try
{
String QueryString;
String loanid=request.getParameter("loanid");  
String bookid=request.getParameter("bookid");  
int branchid=Integer.parseInt(request.getParameter("branchid"));  
String cardno=request.getParameter("cardno");  
Connection connection = null;
Statement st1 = null, st2= null, st3=null;
ResultSet rs = null, rs1=null;
Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","nandy123"); 
st1 = connection.createStatement();
String update="update book_loans set Date_out = NULL and Due_date = NULL and Date_in = curdate() where loan_id = "+loanid+";";
//String fine = "select fine from fine_amt where loan_id='"+loanid+"'";
st1.executeUpdate(update);

st2 = connection.createStatement();
st3 = connection.createStatement();
String copies="update book_copies set no_of_copies = no_of_copies + 1 where book_id = '"+bookid+"' and branch_id = '"+branchid+"';";
st2.executeUpdate(copies);
double x=0;

String fine = "select fine_amt from fine where loan_id="+loanid+";";
PreparedStatement pr1 = (PreparedStatement) connection.prepareStatement(fine);
rs = pr1.executeQuery(fine);

if(rs.next())
    x=Double.parseDouble(rs.getString(1));

if(x > 0)
{
    out.println("A fine of "+x+" was paid for returning the book late \n \n \n ");
}

String paid="update fine set paid = 'Y' where loan_id="+loanid+";";
st3.executeUpdate(paid);
        
%>        
<b><font size="+3" color="green"></font> </b></table>
</center>
    <% // out.println("Book was due on "+duedate+"Please pay a fine of "+fine+"$");
}
catch( Exception e)
{ 
    out.println("E"+ e);
}

   // fine=0;%>

<center><h3>Thanks for using our system</h3>
<h3><a href="search.jsp">To borrow more books</a></h3>
<h3><a href="check_in.jsp">Check In</a></h3>
  

 </body>
</html>
