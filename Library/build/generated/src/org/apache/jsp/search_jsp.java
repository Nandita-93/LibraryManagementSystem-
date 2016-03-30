package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.lang.*;
import java.lang.String;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Search Your Book Here </title>\n");
      out.write("<script>\n");
      out.write("    var check = document.getElementsByName('search');\n");
      out.write("    if(check[0].checked)\n");
      out.write("        public check1=\"bookid\";\n");
      out.write("    else if(check[1].checked)\n");
      out.write("        check2=\"title\";\n");
      out.write("    else if (check[2].checked)\n");
      out.write("        check3=\"author\";\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body bgcolor = \"grey\">\n");
      out.write("    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("<form method=\"post\" action=\"searchresults.jsp\">\n");
      out.write("<center><h2><font color=\"black\"> Book Search </font></h2>\n");
      out.write("<h3><font color=\"black\">Select any one of the category </font></h3></center>\n");
      out.write("<br/>\n");
      out.write("<p>\n");
      out.write("<table cellspacing=\"10\">\n");
      out.write("<tr>\n");
      out.write("    \n");
      out.write(" <td><input type=\"checkbox\"  name=\"search\" value=\"bookid\"/><font color=\"black\">Book ID</font></td><br/>\n");
      out.write("<td><font color=\"black\">Enter Book ID</font></td>\n");
      out.write("<td><input type=\"text\" name=\"bookid\"<br/></td>\n");
      out.write("</tr>\n");
      out.write("<br/>\n");
      out.write("<tr>\n");
      out.write(" <td><input type=\"checkbox\" name=\"search\" value=\"title\"/><font color=\"black\">Title</font><br/></td>\n");
      out.write(" <td><font color=\"black\">Enter Title</font></td>\n");
      out.write("<td><input type=\"text\" name=\"title\"/><br/></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write(" <td><input type=\"checkbox\" name=\"search\" value=\"author\"/><font color=\"black\">Author</font><br/></td>\n");
      out.write("<td><font color=\"black\">Enter Author Name</font></td>\n");
      out.write("<td><input type=\"text\" name=\"author\"/><br/></td>\n");
      out.write("</tr>\n");
      out.write("<br>\n");
      out.write("\n");
      out.write("</table>\n");
      out.write("<br><br>\n");
      out.write("<table>\n");
      out.write("<tr>\n");
      out.write("    <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enter you card number</td>\n");
      out.write("    <td><input type=\"text\" name=\"cardno\"></td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write(" <!--<a href=\"index.jsp\">Logout</a>-->\n");
      out.write("  <center><input type=\"submit\" value=\"Check Out\"></center>\n");
      out.write("</form>\n");
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
