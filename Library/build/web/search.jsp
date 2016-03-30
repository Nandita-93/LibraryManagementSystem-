<%--
    Document   : search
    Created on : 26 Mar, 2014, 7:51:32 PM
    Author     :  nanda
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Your Book Here </title>
<script>
    var check = document.getElementsByName('search');
    if(check[0].checked)
        public check1="bookid";
    else if(check[1].checked)
        check2="title";
    else if (check[2].checked)
        check3="author";
</script>
</head>
<body bgcolor = "grey">
    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>
<%@ page language="java" %>
<%@ page import ="java.sql.*" %>
<%@ page import ="java.lang.*"%>
<%@ page import ="java.lang.String"%>    


<form method="post" action="searchresults.jsp">
<center><h2><font color="black"> Book Search </font></h2>
<h3><font color="black">Select any one of the category </font></h3></center>
<br/>
<p>
<table cellspacing="10">
<tr>
    
 <td><input type="checkbox"  name="search" value="bookid"/><font color="black">Book ID</font></td><br/>
<td><font color="black">Enter Book ID</font></td>
<td><input type="text" name="bookid"<br/></td>
</tr>
<br/>
<tr>
 <td><input type="checkbox" name="search" value="title"/><font color="black">Title</font><br/></td>
 <td><font color="black">Enter Title</font></td>
<td><input type="text" name="title"/><br/></td>
</tr>
<tr>
 <td><input type="checkbox" name="search" value="author"/><font color="black">Author</font><br/></td>
<td><font color="black">Enter Author Name</font></td>
<td><input type="text" name="author"/><br/></td>
</tr>
<br>

</table>
<br><br>
<table>
<tr>
    <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter you card number</td>
    <td><input type="text" name="cardno"></td>
</tr>
</table>
 <!--<a href="index.jsp">Logout</a>-->
  <center><input type="submit" value="Check Out"></center>
</form>
</body>
</html>