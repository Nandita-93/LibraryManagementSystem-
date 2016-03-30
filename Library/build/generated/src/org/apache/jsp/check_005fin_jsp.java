package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class check_005fin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Check In </title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"grey\">\n");
      out.write("<br><br>\n");
      out.write("<center><h1>CHECK IN BOOKS</h1>\n");
      out.write("    <h3>Enter the following details</h3>\n");
      out.write("    <form method=\"post\" action=\"check_in_results.jsp\">\n");
      out.write("    <table>\n");
      out.write("    ");
/*
        String a1=request.getParameter("bookid");
        out.println("A1"+a1);
        int a4=Integer.parseInt(request.getParameter("branchid"));
        out.println("A4"+a4);
        */    
      out.write("\n");
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td><font color=\"black\">Enter your Card No</font></td>\n");
      out.write("        <td><input type=\"text\" name=\"cardno\"/><br/></td>\n");
      out.write("    </tr>    \n");
      out.write("    \n");
      out.write("    </table>\n");
      out.write("        <br>\n");
      out.write("         <!-- <input type=\"hidden\" name=\"bookid\" value=\"<//%=a1%>\">\n");
      out.write("          <input type=\"hidden\" name=\"branchid\" value=\"<//%=a4%>\"> -->\n");
      out.write("        <input type=\"submit\" value=\"Check In\" name=\"Check In\" size=\"15\">\n");
      out.write("    </form></center>\n");
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
