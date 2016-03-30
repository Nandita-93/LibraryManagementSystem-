import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class register extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String name=request.getParameter("username");
            String fname=request.getParameter("names");
            String lname=request.getParameter("lname");
            String emaill;
                    emaill = request.getParameter("email");
            String pass=request.getParameter("p1");
            String phone=request.getParameter("num");
            String sql="insert into userreg values(?,?,?,?,?,?)";
             //String sql="insert into userreg values(?,?)";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c=DriverManager.getConnection("jdbc:odbc:lib");
            PreparedStatement pr = c.prepareStatement(sql);
            pr.setString(1,name);
            pr.setString(2,pass);
            pr.setString(3,fname);
            pr.setString(4,lname);
            pr.setString(5,phone);
            pr.setString(6,emaill);
            pr.executeUpdate();
          // int numRowsChanged = pr.executeUpdate();
  // show that the new account has been created
  /*out.println(" Hello : ");
  out.println(" '"+fname+"'");*/
  pr.close();
  response.sendRedirect("P2.jsp");
  }
  catch(ClassNotFoundException e){
  out.println("Couldn't load database driver: "
  + e.getMessage());
  }
  catch(SQLException e){
  out.println("SQLException caught: "
  + e.getMessage());
  }
  catch (Exception e){
  out.println(e);
  }
}
}
