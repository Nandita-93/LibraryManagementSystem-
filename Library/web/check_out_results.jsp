<%--
    Document   : searchresults
    Created on : 26 Mar, 2014, 7:51:47 PM
    Author     : nanda
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Check IN</title>
</head>

<body bgcolor = "grey">
    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>
<%@ page language="java" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.lang.*"%>
<%@ page import ="java.util.Date" %>
<%@ page import ="java.text.DateFormat" %>
<%@ page import ="java.text.SimpleDateFormat" %>
<%@ page import ="java.util.Calendar" %>
<%@ page import ="java.lang.System" %>

<%
try
{
   
String QueryString;
Connection connection = null;
Statement statement = null;
int a;
 ResultSet rs1=null;
//PrinterWriter out;
//String bookid=request.getParameter("bookid");
 String bookid=request.getParameter("bookid");
int branchid=Integer.parseInt(request.getParameter("branchid"));
int cardno=Integer.parseInt(request.getParameter("cardno"));
int copies=Integer.parseInt(request.getParameter("copies"));
/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
connection = DriverManager.getConnection("jdbc:odbc:data2","3023","3023");
*/
//out.println(bookid+branchid+"FGG"+copies+ "dxbxbxf"+cardno);
//
int check=0;

if (copies<0 || copies==0)
{
    check=1;
    copies--;
}
//out.println("COUNT"+a);
  Class.forName("com.mysql.jdbc.Driver");
  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","nandy123");  
  ResultSet rs=null;
String s="select * from book_loans where book_id='"+bookid+"' and branch_id='"+branchid+"' and card_no='"+cardno+"'";
PreparedStatement pr1 = (PreparedStatement) connection.prepareStatement(s);
rs = pr1.executeQuery(s);
if(rs.next()){
    out.println("You have already borrowed this book! ");
    }
else{
statement = connection.createStatement();
String sql="update book_copies set no_of_copies = '"+copies+"' where book_id = '"+bookid+"' and branch_id = '"+branchid+"'";
statement.executeUpdate(sql);
QueryString="insert into book_loans(book_id, branch_id, card_no, Date_out, Due_date) values('"+bookid+"','"+branchid+"','"+cardno+"',curdate(),date_add(date_out, INTERVAL + 14 DAY));";
  //out.println("afr q");
  //out.println("UP");
  PreparedStatement pr = (PreparedStatement) connection.prepareStatement(QueryString);
pr.executeUpdate();
SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
   //get current date time with Date()
   Date date = new Date();
   //System.out.println(dateFormat.format(date)); don't print it, but save it!
   String date_out1 = df.format(date);
  
   Calendar c = Calendar.getInstance();
c.setTime(new Date()); // Now use today date.
c.add(Calendar.DATE, 14); 
String due_date1 = df.format(c.getTime());
/*
           // stmt.setString(2,Title[i]);
out.println("after q");
             int i=stmt.executeUpdate();
out.println("after q");
String QueryString1 = "select title from book where bookid=bookid;";
rs = statement.executeQuery(QueryString1); */
out.println(" <h3>You have successfully checked out the book and you should return it by " + due_date1  ); 
}
out.println("Thank You!</h3>");
%>
<br>
<h3><a href="search.jsp">To borrow more books</a></h3>
<h3><a href="check_in.jsp">Check In</a></h3>
<%

connection.close();
}
catch(Exception e)
{
    System.err.println(e.getMessage());
}

%>
</body>
</html>