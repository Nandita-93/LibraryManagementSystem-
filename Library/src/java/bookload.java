
import java.sql.*;
import java.io.*;

public class bookload{
    public static void main(String[] args){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","nandy123");
            Statement st=c.createStatement();
            String fileName = "C:/Users/nanda/csv files/books.csv";
            BufferedReader BR = new BufferedReader (new FileReader(fileName));
            BR.readLine();
            String line = null;
            String BOOKID[] = new String[280500];
            String Title[]= new String[280500];
            //String columnValues[]= "";
            int i=0;
            line = BR.readLine();
            while(line!=null)
            { 
             String  columnValues[] = line.split("	");
             BOOKID[i] = columnValues[0];
             Title[i] = columnValues[1];
             
             System.out.println(BOOKID[i]);
             System.out.println(Title[i]);
             
            // String str = "insert into person_details values (?, ?)";
             ////query = con.prepareStatement(str);
            // query.setInt(1, 1);
             // query.setString(2, "D'souza");
             // query.executeUpdate();
             
             String a=BOOKID[i], b=Title[i];
             System.out.println(a);
            /* System.out.println(No_of_copies[i]);*/
            // String query_string = "insert into Book(BOOKID, Title) values (?,?)";
            /* String query = "LOAD DATA INFILE '"+books.csv+"' INTO TABLE books (text,price);";
             PreparedStatement query = c.prepareStatement(query_string);
             query.setString(1,a);
             query.setString(2,b);
             query.executeUpdate(); */
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
