import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class search extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        try{

            String search1=request.getParameter("search1");
            //String sql="SELECT * FROM book, book_authors where bookid ='"+ search1 + "' or title like '"+ search1 +"%' or book_author like '"+ search1 +"%'";
            String sql="select * from book where bookid ='\"+ search1 + \"' or title like '\"+ search1 +\"%'";
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","nandy123");  
            Statement st=c.createStatement();
           ResultSet rs= st.executeQuery(sql);
            String fileName = "C:\\Users\\nanda\\csv files\\book.csv";
            BufferedReader BReader = new BufferedReader (new FileReader(fileName));
            BReader.readLine();
            String line = null;
             int i=0;
            line = BReader.readLine();
            while(line!=null)
            { 
                out.println(" '"+rs.getString(1)+"'");
                out.println(" '"+rs.getString(2)+"'");
            }
            
        }
        catch(Exception e){}
        finally
        {
            out.close();
                    };
    }
}
      
