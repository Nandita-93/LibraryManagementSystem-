import java.sql.*;
import java.io.*;

public class NewClass1{
    public static void main(String[] args){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","nandy123");
            Statement st=c.createStatement();
            String fileName = "C:/Users/nanda/csv files/book.csv";
            BufferedReader BR = new BufferedReader (new FileReader(fileName));
            BR.readLine();
            String line = null;
            
            String BookID[] = new String[2650000];
            String Title[] = new String[2650000];
            
            
                        int i=0;
            line = BR.readLine();
            while(line!=null)
            { 
             String  columnValues[] = line.split("	");
             //Branch_ID[i] = Integer.parseInt(columnValues[0]);
             BookID[i] = columnValues[0];
             Title[i] = columnValues[2];
             
            
             st.executeUpdate("insert into Book(BookID, Title) values ("+BookID[i]+",'"+Title[i]+"');");
             i++;
             line = BR.readLine();
            /*  String Author = columnValues[2];
              String Year = columnValues[3];   "'"
              String Publisher = columnValues[4];
              System.out.println("ISBN" +ISBN);
              System.out.println("Title" +Title);
             //sample query = insert into table_name (id, name) values ("+id+","name");
            */
             }
            
           /*
            ResultSet rs= st.executeQuery("select * from book");
            if(rs.next())
            {
                System.out.println("WHILE");
                System.out.println("Book ID:"+"rs.getInt('BOOKID')");
            } */
        } catch (Exception ex) {
                System.out.println(ex);
        } 
        /*
        catch (ClassNotFoundException ex) {
           System.out.println(ex);
        } */
    }
}