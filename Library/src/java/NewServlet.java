import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class NewServlet {
   public static void main(String[] args) {

   DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
   //get current date time with Date()
   Date date = new Date();
   //System.out.println(dateFormat.format(date)); don't print it, but save it!
   String yourDate = sdf.format(date);

   System.out.println(yourDate);
   Calendar c = Calendar.getInstance();
c.setTime(new Date()); // Now use today date.
c.add(Calendar.DATE, 5); // Adding 5 days
String output = sdf.format(c.getTime());
System.out.println(c);
System.out.println(output);

   
   
 }
}