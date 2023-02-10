
package alpona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connection {
   public static Connection getConnection() throws SQLException{
       Connection con=null;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
       }
       con= DriverManager.getConnection("jdbc:mysql://localhost:3306/alpona", "root", "u1904116");
       return con;
   }
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/alpona", "root", "u1904116");
                System.out.println("Connection is successsfull");
                String query= "insert into supplier(Uname, Fname, Lname, Password, Mobile, Email, District, Address) values('Arian12','Nasrul','Karib','admin','01767602377','karibarian12@gmail.com','Dhaka','Meradia,Khilgaon')";
                Statement statement= connection.createStatement();
                statement.execute(query);
            } catch (SQLException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
