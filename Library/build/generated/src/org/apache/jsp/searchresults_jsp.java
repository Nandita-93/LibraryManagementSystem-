package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.lang.*;
import java.lang.String;

public final class searchresults_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>display data from the table using jsp</title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"grey\">\n");
      out.write("    <h2><b><font color=\"black\" >Search Results</font></b></h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");

try
{
String QueryString;

Connection connection = null;
Statement statement = null;
ResultSet rs = null;
String[] search=request.getParameterValues("search");
String a1 =request.getParameter("bookid");
String a2=request.getParameter("title");
String a3=request.getParameter("author");
/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
connection = DriverManager.getConnection("jdbc:odbc:data2","3023","3023");
*/
  Class.forName("com.mysql.jdbc.Driver");
  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","nandy123");  


statement = connection.createStatement();

    if (search[0].equals("bookid")){
    QueryString = "SELECT book.bookid, title, author_name from book, book_authors where book.bookid ='" +a1+ "' and book.bookid=book_authors.bookid";
    rs = statement.executeQuery(QueryString);
    }
    else if (search[1].equals("title")){
    QueryString = "SELECT book.bookid, title, author_name from book, book_authors where title like '%" +a2+ "%' and book.bookid = book_authors.bookid";
    rs = statement.executeQuery(QueryString);
    }
    else if (search[2].equals("author")){
    QueryString = "SELECT book.bookid, title, author_name from book, book_authors where author_name like '%" +a3+ "%' and book.bookid = book_authors.bookid";
    rs = statement.executeQuery(QueryString);  
    }
    else if (search[0].equals("bookid") && search[2].equals("author")){
    QueryString = "SELECT book.*, book_authors.author_name, no_of_copies, branch_id  from book, book_authors where author_name like '%" +a3+ "%' and book.bookid = book_authors.bookid ";
    rs = statement.executeQuery(QueryString);
    } 
    else if (search[0].equals("bookid") && search[1].equals("title")){
    QueryString = "SELECT book.*, book_authors.author_name, no_of_copies, branch_id  from book, book_authors where title like '%" +a2+ "%' AND book.bookid = book_authors.bookid ";
    rs = statement.executeQuery(QueryString);
    }
    else if (search[1].equals("title") && search[2].equals("author")){
    QueryString = "SELECT book.*, book_authors.author_name, no_of_copies, branch_id  from book, book_authors where author_name like '%" +a3+ "%' and  AND title like '%" +a2+ "%' and book.bookid = book_authors.bookid ";
    rs = statement.executeQuery(QueryString);
    }
    else if (search[1].equals("title") && search[2].equals("author") && search[0].equals("bookid")){
    QueryString = "SELECT book.*, book_authors.author_name, no_of_copies, branch_id  from book, book_authors where book.bookid= '"+a1+"' and author_name like '%" +a3+ "%' AND title like '%" +a2+ "%' and book.bookid = book_authors.bookid ";
    rs = statement.executeQuery(QueryString);
    }




      out.write("\n");
      out.write("<TABLE cellpadding=\"15\" border=\"1\" style=\"background-color: #ffffcd;\">\n");
      out.write("<TBODY>\n");
      out.write("<TH>BOOK ID</TH>\n");
      out.write("<TH>TITLE</TH>\n");
      out.write("<TH>Author</TH>\n");
      out.write("<TH>Branch ID</th>\n");
      out.write("<th>No of Copies</th>\n");
      out.write("<th>Returns & Appraisals</th>\n");
      out.write("\n");

while (rs.next())
{

      out.write("\n");
      out.write("<TR>\n");
      out.write("<TD>");
      out.print(rs.getString(1));
      out.write("\n");
      out.write("    <input type=button onClick=window.open(\"publisher1.jsp\",\"Ratting\",\"width=550,height=170,left=150,top=200,toolbar=0,status=0,\"); value=\"Open Window\">\n");
      out.write("</TD>\n");
      out.write("<TD>");
      out.print(rs.getString(2));
      out.write("</TD>\n");
      out.write("<TD>");
      out.print(rs.getString(3));
      out.write("</TD>\n");
      out.write("<TD>");
//=rs.getString(4)
      out.write("</TD>\n");
      out.write("<TD>");
//=rs.getString(5)
      out.write("</TD>\n");
      out.write("<TD>\n");
      out.write("    <form method=\"post\" action=\"checkin_results.jsp\">\n");
      out.write("        <input type=\"submit\" value=\"Check In\" name=\"Check In\" size=\"15\">\n");
      out.write("    </form>\n");
      out.write("    <br>\n");
      out.write("    <form method=\"post\" action=\"checkout_results.jsp\">\n");
      out.write("        <input type=\"submit\" value=\"Check Out\" name=\"Check Out\" size=\"15\">\n");
      out.write("    </form>\n");
      out.write("</TD>\n");
      out.write("</TR>\n");

}

      out.write('\n');

rs.close();
statement.close();
connection.close();
} catch (Exception ex) {

      out.write("\n");
      out.write("<b><font size=\"+3\" color=\"green\"></font> </b>\n");

out.println("Unable to connect to database.");
}

      out.write("\n");
      out.write("</TBODY>\n");
      out.write("</TABLE>\n");
      out.write("<TABLE>\n");
      out.write("<TR>\n");
      out.write(" <a href=\"search.jsp\"> <button type=submit>back</button></a>\n");
      out.write("<a href=\"index.jsp\"> <button type=submit>logout</button></a>\n");
      out.write("</TR>\n");
      out.write("</TABLE>\n");
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
