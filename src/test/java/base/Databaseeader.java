package base;

import java.sql.*;
import java.sql.DriverManager;

public class Databaseeader {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","admin");
        Statement statement = dbcon.createStatement();
        ResultSet rs = statement.executeQuery("select * from selenium.AMAZON_PRODUCTS");

        while (rs.next()){
            //System.out.println(rs.getString("USER_NAME"));
            String str = rs.getString("USER_NAME");
            if (str.equalsIgnoreCase("User4")){
                System.out.println(rs.getString("PRODUCT_NAME"));
            }
        }
    }
}
