<%--
    Document   : searchresults
    Created on : 26 Mar, 2014, 7:51:47 PM
    Author     : nanda
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Search books</title>
</head>
<body bgcolor="grey">
    
    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>
    <h2><font color="black" >Search Results</font></h2>
<%@ page language="java" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.lang.*"%>
<%@ page import ="java.lang.String"%>    
<%
try
{
String QueryString, Query;
int a4, a5, a6;
String a7, a8;
Connection connection = null;
Statement statement = null, st1=null;
ResultSet rs = null, rs1=null, rs2=null,rs3=null;
String[] search=request.getParameterValues("search");
String a1=null;
 a1 =request.getParameter("bookid");
String a2=request.getParameter("title");
String a3=request.getParameter("author");
a6=Integer.parseInt(request.getParameter("cardno"));
Class.forName("com.mysql.jdbc.Driver");
  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","nandy123");  
statement = connection.createStatement();

String QueryString2 = "select * from borrower where card_no = "+a6+";";
PreparedStatement pr3 = (PreparedStatement) connection.prepareStatement(QueryString2);
rs3 = pr3.executeQuery(QueryString2);

if(!rs3.next()){
  out.println("Invalid User! Please register"); 
  %>
    <h3><a href = "register.jsp">Register Here!</a></h3>
    <%
}
else{
String view = "create view view1 as select book_id, group_concat(author_name SEPARATOR ',') as 'author_name' from book_authors group by book_id;";
PreparedStatement pr2 = (PreparedStatement) connection.prepareStatement(view);
pr2.executeUpdate(view);
st1 = connection.createStatement();
    if (search[0].equals("bookid")){
    QueryString = "select book.book_id, book.title, view1.author_name, branch_id, no_of_copies from book, view1, book_copies where book.book_id = '"+a1+"' and book.book_id = view1.book_id and book.book_id = book_copies.book_id and book_copies.book_id = view1.book_id;";
    PreparedStatement pr = (PreparedStatement) connection.prepareStatement(QueryString);
    rs = pr.executeQuery(QueryString);
    }
    else if (search[0].equals("title")){
    QueryString = "select book.book_id, book.title, view1.author_name, branch_id, no_of_copies from book, view1, book_copies where book.book_id = view1.book_id and book.book_id = book_copies.book_id and book_copies.book_id = view1.book_id and book.title like '"+a2+"';";
    PreparedStatement pr = (PreparedStatement) connection.prepareStatement(QueryString);
    rs = pr.executeQuery(QueryString);
    }
    else if (search[0].equals("author")){
    QueryString = "select book.book_id, book.title, view1.author_name, branch_id, no_of_copies from book, view1, book_copies where book.book_id = view1.book_id and book.book_id = book_copies.book_id and book_copies.book_id = view1.book_id and view1.author_name like'%"+a3+"%';";
    PreparedStatement pr = (PreparedStatement) connection.prepareStatement(QueryString);
    rs = pr.executeQuery(QueryString);
    
    }
    else if (search[0].equals("bookid") && search[1].equals("author")){
    QueryString = "select book.book_id, book.title, view1.author_name, branch_id, no_of_copies from book, view1, book_copies where book.book_id = '"+a1+"' and author_name like '%"+a3+"%' and book.book_id = view1.book_id and book.book_id = book_copies.book_id and book_copies.book_id = view1.book_id;";
    PreparedStatement pr = (PreparedStatement) connection.prepareStatement(QueryString);
    rs = pr.executeQuery(QueryString);
    } 
    else if (search[0].equals("bookid") && search[1].equals("title")){
    QueryString = "select book.book_id, title, view1.author_name, branch_id, no_of_copies from book, view1, book_copies where book.book_id = '"+a1+"' and title like '%"+a2+"%' and book.book_id = view1.book_id and book.book_id = book_copies.book_id and book_copies.book_id = view1.book_id;";
    PreparedStatement pr = (PreparedStatement) connection.prepareStatement(QueryString);
    rs = pr.executeQuery(QueryString);
    }
    else if (search[0].equals("title") && search[1].equals("author")){
    QueryString = "select book.book_id, title, view1.author_name, branch_id, no_of_copies from book, view1, book_copies where author_name like '%"+a3+"%' and title like '%"+a2+"%' and book.book_id = view1.book_id and book.book_id = book_copies.book_id and book_copies.book_id = view1.book_id;";
    PreparedStatement pr = (PreparedStatement) connection.prepareStatement(QueryString);
    rs = pr.executeQuery(QueryString);
    }
    else if (search[1].equals("title") && search[2].equals("author") && search[0].equals("bookid")){
    QueryString = "select book.book_id, title, view1.author_name, branch_id, no_of_copies from book, view1, book_copies where book_id = '"+a1+"' and author_name like '%"+a3+"%' and title like '%"+a2+"%' and book.book_id = view1.book_id and book.book_id = book_copies.book_id and book_copies.book_id = view1.book_id;";
    PreparedStatement pr = (PreparedStatement) connection.prepareStatement(QueryString);
    rs = pr.executeQuery(QueryString);   
    }
%>
<TABLE cellpadding="15" border="1" style="background-color: #ffffcd;">
<TBODY>
<TH>BOOK ID</TH>
<TH>TITLE</TH>
<TH>Author</TH>
<TH>Branch ID</th>
<th>No of Copies</th>
<th>Returns & Appraisals</th>
<%
while (rs.next())
{
%>
<TR>
<TD><%=rs.getString(1)%> </TD>
<TD><%=rs.getString(2)%>
 
</TD>
<TD><%=rs.getString(3)%>
  
</TD>
<TD><%=rs.getString(4)%>
 <%  
 a4= Integer.parseInt(rs.getString(4)); 
 %>
</TD>
<TD><%=rs.getString(5)%>
 <%  
 a5= Integer.parseInt(rs.getString(5)); 
 %>
</TD>
<TD>
    <form method="get" action="check_out_results.jsp">
        <input type="hidden" name="bookid" value="<%=a1%>">
        <input type="hidden" name="branchid" value="<%=a4%>">
        <input type="hidden" name="copies" value="<%=a5%>">
        <input type="hidden" name="cardno" value="<%=a6%>">
        <input type="submit" value="Check Out" name="Check Out" size="15">
    </form>
    <br>
</TD>

</TR>
<%
}
rs.close();
String view1 = "drop view view1;";
PreparedStatement pr1 = (PreparedStatement) connection.prepareStatement(view1);
pr1.executeUpdate(view1);

statement.close();
st1.close();
connection.close();
} }
catch (Exception ex) {
out.println("\n Unable to connect to database.");
  out.println("EX:"+ex);
}
finally{
}
%>
</TBODY>
</TABLE>
<TABLE>
<TR>
<a href="search.jsp"> <button type=submit>Back</button></a>
<a href="index.jsp"> <button type=submit>Logout</button></a>
</TR>
</TABLE>
</body>
</html>