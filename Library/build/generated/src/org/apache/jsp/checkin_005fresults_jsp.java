package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.lang.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.System;

public final class checkin_005fresults_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Check IN</title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"grey\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

try
{
String QueryString;

Connection connection = null;
Statement statement = null;
//PrinterWriter out;
String bookid=request.getParameter("bookid");
String branchid=request.getParameter("branchid");
String cardno=request.getParameter("cardno");
/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
connection = DriverManager.getConnection("jdbc:odbc:data2","3023","3023");
*/
  Class.forName("com.mysql.jdbc.Driver");
  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","nandy123");  
  ResultSet rs=null;

statement = connection.createStatement();

   SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
   //get current date time with Date()
   Date date = new Date();
   //System.out.println(dateFormat.format(date)); don't print it, but save it!
   String date_out = df.format(date);
   String date_in = null;
   Calendar c = Calendar.getInstance();
c.setTime(new Date()); // Now use today date.
c.add(Calendar.DATE, 14); // Adding 5 days
String due_date = df.format(c.getTime());
System.out.println(due_date);

//QueryString = "SELECT book.*,  ='" +a1+ "'";
//QueryString = "INSERT into book_loans values(?,?,?,?,?,?)";

QueryString = "insert into book_loans values ('"+bookid+"','"+branchid+"','"+cardno+"','"+date_out+"','"+due_date+"','"+date_in+"');";
             PreparedStatement stmt = connection.prepareStatement(QueryString);
            // stmt.setString(1,Book_ID[i]);
            // stmt.setString(2,Title[i]);
             stmt.executeUpdate();
String QueryString1 = "select title from book where bookid=bookid;";
rs = statement.executeQuery(QueryString1);
out.println(" <h1>You have successfully checked out the book  " + rs.getString(1) + " and you should return it by " + due_date );

      out.write('\n');
      out.write('\n');
/*
PreparedStatement pr = connection.prepareStatement(QueryString);
pr.setString(1,bookid);
pr.setString(2,branchid);
pr.setString(3,cardno);
pr.setString(4,date_out);
pr.setString(5,due_date);
pr.setString(6,date_in);
pr.executeUpdate();
pr.close();  */

}
catch(Exception e)
{
}


      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
