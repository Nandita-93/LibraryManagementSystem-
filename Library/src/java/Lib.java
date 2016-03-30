import java.sql.*;
import java.io.*;

public class Lib{

	public static void main(String[] args) {
		
		try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","nandy123");
            //Statement s = conn.createStatement();
            
            
            
            String fileName = "C:\\Users\\nanda\\csv files\\book_copies.csv";
            BufferedReader BReader = new BufferedReader (new FileReader(fileName));
            BReader.readLine();
            String line = null;
          /*  String Book_ID_top[] = new String[280500];
            Integer Branch_top[] = new Integer[280500];
            Integer Copies_top[] = new Integer[500];*/
            String BookID[] = new String[10700];
            Integer Branch_id[] = new Integer[10700];
            Integer No_of_copies[] = new Integer[10700];
            int i=0, j=0;
            while (j<10240)
            {
            line = BReader.readLine();
            j++;
            }
             // line = BReader.readLine();
            while(line!=null)
            { 
             String  columnValues[] = line.split("	");
             BookID[i] = columnValues[0];
             Branch_id[i] = Integer.parseInt(columnValues[1]);
             No_of_copies[i] = Integer.parseInt(columnValues[2]);
            
             
             
            System.out.println(BookID[i]);
            System.out.println(Branch_id[i]);
            System.out.println(No_of_copies[i]);
             try{
             String query_string = "insert into book_copies(bookid,Branch_ID, No_of_copies) values ('"+BookID[i]+"','"+Branch_id[i]+"','"+No_of_copies[i]+"');";
             PreparedStatement stmt = conn.prepareStatement(query_string);
            // stmt.setString(1,Book_ID[i]);
            // stmt.setString(2,Title[i]);
             stmt.executeUpdate();
             }
             
             catch(com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException e)
             { 
                 i++;
                 line= BReader.readLine();
                 continue;
             }
            catch(com.mysql.jdbc.exceptions.MySQLSyntaxErrorException e)
             { 
                 i++;
                 line= BReader.readLine();
                 continue;
             }
             catch(com.mysql.jdbc.MysqlDataTruncation e)
             {
                 i++;
                 line= BReader.readLine();
                 continue;

             }
             i++;         
                       
             line = BReader.readLine();
            /*  String Author = columnValues[2];
              String Year = columnValues[3];   "'"
              String Publisher = columnValues[4];
              System.out.println("ISBN" +ISBN);
              System.out.println("Title" +Title);
             //sample query = insert into table_name (id, name) values ("+id+","name");
             
             */
            
            }
           // stmt = conn.createStatement();
            //stmt.executeUpdate("insert into book(book_id,title)VALUES (4,'ALGOS');"); 
           // ResultSet rs = stmt.executeQuery("select * from book");
          /*  
            while (rs.next())
            	{ System.out.println("inside while");
            		System.out.println("Book id:"+rs.getInt("book_id"));
            	}*/
		
		} catch (Exception ex) {
            System.out.println(ex);
        }
		
	}

}