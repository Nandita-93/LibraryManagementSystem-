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
import java.util.concurrent.TimeUnit;

public final class batch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      \n");
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
QueryString = "select loan_id,  Due_date book_loans where Due_date is not null;";
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
}
catch(Exception e)
{
out.println(e);
}

      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
