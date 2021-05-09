package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class JdbcService {

    static Logger logger = LogManager.getLogger(JdbcService.class);

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USERNAME = "postgres";
    static final String PSW = "1234567";

    Connection connection = null;
    Statement statement = null;

    public JdbcService(){
        logger.info("Setup connection to Postgres DB.");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Postgres JDBC Driver is not found");
            logger.error(e.getMessage());
            return;
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PSW);
        } catch (SQLException e) {
            logger.error("Connection is failed");
            logger.error(e.getMessage());
            return;
        }

        if(connection != null){
            logger.info("Successfully connectied to db");
        }else{
            logger.info("Failed connected to db");
        }
    }


    public Connection getConnection(){
        return connection;
    }

    public Statement getStatement() {
        try {
            if (statement == null) {
                statement = connection.createStatement();
            }
        } catch (SQLException ex) {
            logger.error("Не удалось создать statemen.");
            logger.error(ex.getMessage());
        }
        return statement;
    }

    public void executeSQL(String sql){
        try{
            getStatement().execute(sql);
        }catch (SQLException ex){
            logger.error(ex.getMessage());
        }
    }

    public ResultSet executeQuery(String sql){
        ResultSet resultSet = null;
        try{
            resultSet = getStatement().executeQuery(sql);
            logger.info("SQL: " + " has been executed");
        }catch (SQLException ex){
            logger.error(ex.getMessage());
        }
        return resultSet;
    }

    public void closeStatemen(){
        try {
            statement.close();
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }

    public void closeConnection(){
        try {
            connection.close();
            logger.info("The connection has been closed");
        } catch (SQLException throwables) {
            logger.error("Could not close connection");
            logger.error(throwables.getMessage());
        }
    }
}
