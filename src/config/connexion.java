package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connexion {
    private static String URL="jdbc:mysql://localhost:3306/banque_db";
    private static String Username="myuser";
    private static String password="mapassword";

    public static Connection ouvrir()throws ClassNotFoundException,SQLException{
        return DriverManager.getConnection(URL,Username,password);
    }
}
