import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by pfunes on 07/07/17.
 */
public class TestConnection {

    public static void main(String[] args) {

        String jdbc = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";

        try{
            System.out.println("Connecting to database: " + jdbc);

            Connection myConn = DriverManager.getConnection(jdbc, user, password);

            System.out.println("Connection Succesfull!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
