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
<title>Check In </title>
</head>
<body bgcolor = "grey">
    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>
<h3>CHECK IN BOOKS</h3>
    
    <form method="post" action="check_in_results.jsp">
    <table>
    <%/*
        String a1=request.getParameter("bookid");
        out.println("A1"+a1);
        int a4=Integer.parseInt(request.getParameter("branchid"));
        out.println("A4"+a4);
        */    %>

    <tr>
        <td><font color="black">Enter your Card No</font></td>
        <td><input type="text" name="cardno"/><br/></td>
    </tr>    
    
    </table>
        <br>
         <!-- <input type="hidden" name="bookid" value="<//%=a1%>">
          <input type="hidden" name="branchid" value="<//%=a4%>"> -->
        <input type="submit" value="Check In" name="Check In" size="15">
    </form></center>

</body>
</html>