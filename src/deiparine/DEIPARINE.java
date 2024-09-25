
package deiparine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class DEIPARINE {


public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); 
            con = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }



    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);    
    System.out.print("Enter Students ID: ");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter Students NAME: ");
    String name = sc.next();
    System.out.print("Enter Students EMAIL: ");
    String email = sc.next();
    System.out.print("Enter Students STATUS: ");
    String stats = sc.next();
    
    String sql = "INSERT INTO students (s_id, s_fname, s_email, s_status) VALUES(?,?,?,?)";
    try{
        Connection con = connectDB();
        PreparedStatement pst = con.prepareStatement(sql);
         pst.setInt(1, id);
         pst.setString(2, name);
         pst.setString(3, email);
         pst.setString(4, stats);
         pst.executeUpdate();
         System.out.println("Inserted Successfully!");
    }catch(SQLException ex){
        System.out.println("Connection Error: " +ex.getMessage());
    };
    }
    
}
