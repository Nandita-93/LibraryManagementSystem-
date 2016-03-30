package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Register</title>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function check()\n");
      out.write("{\n");
      out.write("var name=document.f.fname.value;\n");
      out.write("var p1=document.f.p1.value;\n");
      out.write("var p2=document.f.p2.value;\n");
      out.write("var add=document.f.add.value;\n");
      out.write("var e1=document.f.email.value;\n");
      out.write("var ph=document.f.num.value;\n");
      out.write("var atpos=e1.indexOf(\"@\");\n");
      out.write("var dotpos=e1.lastIndexOf(\".\");\n");
      out.write("if(name.length==0||p1.length==0||p2.length==0||add.length==0||e1.length==0||ph.length==0)\n");
      out.write("{alert(\"Enter all compulsory fields\");return false;}\n");
      out.write("if(atpos<1||dotpos<1||dotpos<atpos+2)\n");
      out.write("{\n");
      out.write("    alert(\"Invalid emailid\");return false;\n");
      out.write("}\n");
      out.write("else \n");
      out.write("    if(!e1.match(/\\b(^(\\S+@)((\\gmail)|(\\ymail)|(\\hotmail)|(\\yahoo))+((\\.com)|(\\.net)|(\\..{2,2}))$)\\b/gi)\n");
      out.write(")\n");
      out.write("{\n");
      out.write("alert(\"Invalid email\");\n");
      out.write("return false;\n");
      out.write("}\n");
      out.write("if(p1!=p2)\n");
      out.write("{\n");
      out.write("    alert(\"Passwords do not match\");return false;\n");
      out.write("}\n");
      out.write("else if(p1.length<6)\n");
      out.write("{\n");
      out.write("    alert(\"Too short password\");return false;\n");
      out.write("}\n");
      out.write("if((!(/^-?\\d+(\\.\\d+)?$/.test(ph)))||ph.length<10)\n");
      out.write("{\n");
      out.write("    alert(\"Invalid phone number\");return false;\n");
      out.write("}\n");
      out.write("}\n");
      out.write("function pass(p1)\n");
      out.write("{\n");
      out.write("var s1=\"strong\";\n");
      out.write("var s2=\"weak\";\n");
      out.write("if(p1.length>6)\n");
      out.write("    document.getElementById(\"passworddes\").innerHTML=s1;\n");
      out.write("else\n");
      out.write("    document.getElementById(\"passworddes\").innerHTML=s2;\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body bgcolor = \"grey\">\n");
      out.write("    <CENTER><br><h1>DALLAS CITY LIBRARY</h1>\n");
      out.write("<form name=\"f\" onsubmit=\"return check()\" action=\"register_db.jsp\" method=\"post\"/>\n");
      out.write("<b>\n");
      out.write("<h2 align=\"center\">Register Here</h2>\n");
      out.write("<center><strong>ENTER ALL THE FIELDS MARKED *</strong></center>\n");
      out.write("<table cellpadding=\"10%\" align=\"center\">\n");
      out.write("<tr>\n");
      out.write("<td><font color=\"black\">First name*</font></td>\n");
      out.write("<td><input type=\"text\" length=30 name=\"fname\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><font color=\"black\">Last name</font></td>\n");
      out.write("<td><input type=\"text\" length=30 name=\"lname\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><font color=\"black\">Address* </font></td>\n");
      out.write("<td><input type=\"text\"  name=\"address\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><font color=\"black\">City </font></td>\n");
      out.write("<td><input type=\"text\"  name=\"city\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><font color=\"black\">State </font></td>\n");
      out.write("<td><input type=\"text\"  name=\"state\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><font color=\"black\">Email id*(this will be used to contact you)</font></td>\n");
      out.write("<td><input type=\"text\"  name=\"email\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><font color=\"black\">Password*(minimum six characters)</font></td>\n");
      out.write("<td><input type=\"password\" length=30 name=\"p1\" onkeydown=\"pass(this.value)\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><font color=\"black\">Retype password*</font></td>\n");
      out.write("<td><input type=\"password\" length=30 name=\"p2\"></td>\n");
      out.write("<td>\n");
      out.write("<label id=\"passworddes\"><font color=\"grey\">password not entered</font></label></td></tr>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><font color=\"black\">Phone*</font></td>\n");
      out.write("<td><input type=\"number\" length=30 name=\"num\"></td>\n");
      out.write("</tr>\n");
      out.write("<tr>\n");
      out.write("<td><input type=\"submit\" value=\"Submit\" ></td>\n");
      out.write("<td><input type=\"Reset\"  ></td>\n");
      out.write("</tr>\n");
      out.write("</font>\n");
      out.write("</b>\n");
      out.write("    </center>\n");
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
