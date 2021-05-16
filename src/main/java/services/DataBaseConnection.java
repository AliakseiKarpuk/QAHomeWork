package services;

import core.ReadProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static Connection connection = null;
    private static ReadProperties properties = new ReadProperties();

    static{
        String url = properties.getDbUrl();
        String user = properties.getDbUser();
        String psw = properties.getDbPsw();

        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,psw);
        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
