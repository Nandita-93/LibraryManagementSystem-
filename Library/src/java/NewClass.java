import java.sql.*;
import java.io.*;

public class NewClass{

	public static void main(String[] args) {
		
		try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","nandy123");
            //Statement s = conn.createStatement();
            
            
            
            String fileName = "C:\\Users\\nanda\\csv files\\book.csv";
            BufferedReader BReader = new BufferedReader (new FileReader(fileName));
            BReader.readLine();
            String line = null;
            String Book_ID_top[] = new String[280500];
            String Title_top[] = new String[280500];
            String BookID[] = new String[280500];
            String Title[] = new String[280500];
            
            int i=0;
            line = BReader.readLine();
            while(line!=null)
            { 
             String  columnValues[] = line.split("	");
             Book_ID_top[i] = columnValues[0];
             Title_top[i] = columnValues[2];
             
           BookID[i] = Book_ID_top[i].replaceAll("\"","");
           Title[i] = Title_top[i].replaceAll("\"","");
           
             
           //System.out.println(BookID[i]);
           //System.out.println(Author[i]);
             
             String query_string = "insert into book(bookid,title) values ('"+BookID[i]+"','"+Title[i]+"');";
             PreparedStatement stmt = conn.prepareStatement(query_string);
            // stmt.setString(1,Book_ID[i]);
            // stmt.setString(2,Title[i]);
             stmt.executeUpdate();
             
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