<%--
    Document   : searchresults
    Created on : 26 Mar, 2014, 7:51:47 PM
    Author     : nanda
--%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Check In</title>
</head>
<body bgcolor = "grey">
    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>
<br><br>
<center><h3>CHECK IN BOOKS</h3>
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
  
Connection connection = null;
Statement statement = null;
ResultSet rs = null, rs1=null,rs2=null;


int cardno=Integer.parseInt(request.getParameter("cardno"));
/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
connection = DriverManager.getConnection("jdbc:odbc:data2","3023","3023");
*/
int i,j=0;
double fine=0;
Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","nandy123");  
statement = connection.createStatement();
/*String QueryString1 = "select card_no from borrower where cardno = "+cardno+";";
PreparedStatement pr2 = (PreparedStatement) connection.prepareStatement(QueryString1);
rs2 = pr2.executeQuery(QueryString1);
if(!rs2.next()){
  out.println("Invalid User! Please register");  
}*/
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
Date date = new Date();
//out.println(date);
Date d = dateFormat.parse(dateFormat.format(date));
//out.println("date"+dateF-ormat.format(date));
QueryString = "select loan_id, book_loans.book_id, title, book_loans.branch_id, branch_name, Date_out, Due_date from book, library_branch, book_loans where book.book_id=book_loans.book_id and library_branch.branch_id=book_loans.branch_id and Date_out is not null and card_no = "+cardno+" ;";
PreparedStatement pr1 = (PreparedStatement) connection.prepareStatement(QueryString);
rs = pr1.executeQuery(QueryString);
 //   rs = statement.executeQuery(QueryString);
//while(rs.next()){
%>
<center>
<TABLE cellpadding="15" border="1" style="background-color: #ffffcd;"> 
<TBODY>  
<TH>BOOK ID</TH>
<TH>Title</TH>
<TH>Branch ID</TH>
<TH>Branch Name</TH>
<TH>Date Out</TH>
<TH>Due Date</th>
<Th>Returns & Appraisals</Th>
<th>Fine</th>
<%
while (rs.next())
{
int a = Integer.parseInt(rs.getString(1));

%>
<TR>
<TD><%=rs.getString(2)%>  </TD>
<TD><%=rs.getString(3)%></TD>
<TD><%=rs.getString(4)%></TD>
<TD><%=rs.getString(5)%></td>
<TD><%=rs.getString(6)%></td>
<TD><%=rs.getString(7)%></td>

<%
Date duedate=rs.getDate(7);
String book_id=rs.getString(2);
int branch_id=Integer.parseInt(rs.getString(4));
%>
<%
long diff= d.getTime() - duedate.getTime();
//out.println("DIFF"+TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
long time = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
int x = d.compareTo(duedate);
//out.println(time);
if(x==1)
      fine= 0.25*time; 
else
      fine = 0;

String sq="insert into fine (loan_id, fine_amt)values ("+a+","+fine+");";
PreparedStatement pr = (PreparedStatement) connection.prepareStatement(sq);
pr.executeUpdate();

%>
<td>
    <%
out.println("Book was due on" + duedate+ " Please pay a fine of "+fine+ "$"); 
%>
</td>
<TD>  <form method="get" action="checkin_update.jsp">
        <input type="hidden" name="bookid" value="<%=book_id%>">
        <input type="hidden" name="branchid" value="<%=branch_id%>">
        <input type="hidden" name="cardno" value="<%=cardno%>">
        <input type="hidden" name="loanid" value="<%=a%>">
    <input type="submit" value="Check In" name="Check In" size="15">
    </form>
</TD>


<%
}

%>
<b><font size="+3" color="green"></font> </b>
</TBODY></table>
<%
rs.close();
statement.close();
connection.close();
} 
catch (Exception ex) {
out.println("Unable to connect to database."+ex);
}
%>

</body>
</html>