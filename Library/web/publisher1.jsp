<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Book Details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body bgcolor = "grey">
    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>
    </center>
        <%@ page language="java" %>
<%@ page language="java" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.lang.*"%>
<%@ page import ="java.lang.String"%>
<%@ page import ="java.util.Date" %>
<%@ page import ="java.text.DateFormat" %>
<%@ page import ="java.text.SimpleDateFormat" %>
<%@ page import ="java.util.Calendar" %>
<%@ page import ="java.lang.System" %>
 
<%
try
{
String QueryString;
//out.println("Child Window");
Connection connection = null;
Statement statement = null;
ResultSet rs = null, rs1=null, rs2=null;

String bookid=request.getParameter("bookid");
int branchid=Integer.parseInt(request.getParameter("branchid"));
int cardno=Integer.parseInt(request.getParameter("cardno"));
int copies=Integer.parseInt(request.getParameter("copies"));
String title=request.getParameter("title");
String author=request.getParameter("author");
//out.println(title);
Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","nandy123");  
statement = connection.createStatement();  
//out.println(bookid);
QueryString = "select cover, publisher, ISBN13, Pages from publisher where book_id = '"+bookid+"'";
String sql = "select branch_name from library_branch where branch_id = "+branchid+";";
PreparedStatement pr = (PreparedStatement) connection.prepareStatement(sql);
rs = pr.executeQuery(sql);
%>
<h3>Book Details</h3>
<h4>Book ID : <% out.println(bookid); %></h4>
<h4>Title : <% out.println(title); %></h4>
<h4>Author : <% out.println(author); %></h4>
<h4>Branch ID : <% out.println(branchid); %></h4>
<%
while(rs.next()){
%>
<h4>Branch Name : <%=rs.getString(1)%></h4>
<%
}
PreparedStatement pr1 = (PreparedStatement) connection.prepareStatement(QueryString);
rs1 = pr1.executeQuery(QueryString);
String x;
while(rs1.next()){
%>
<%//=rs1.getString(1)%>
<% 
x = rs1.getString(1);
String y="\""+x+"\"";
StringBuilder S = new StringBuilder();
S.append("\"");
S.append(x);
S.append("\"");
//out.println(S);
%>
<h4>Publisher : <%=rs1.getString(2)%></h4>
<h4>ISBN13 : <%=rs1.getString(3)%></h4>
<h4>Pages : <%=rs1.getInt(4)%></h4>
<%
} }
catch( Exception e) {
    out.println(e);
}
%>
<h4><a href = "searchresults.jsp">Back</a></h4>
    </body>
</html>
