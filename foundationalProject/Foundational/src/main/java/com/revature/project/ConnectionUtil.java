package com.revature.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {

    private static Connection conn = null;

    private ConnectionUtil(){

    }


    public static Connection getConnection(){

        try {
            if (conn != null && !conn.isClosed()){
                System.out.println("Using an already made connection");
                return conn;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

        String url = "jdbc:postgresql://database-1.cpdj8nkq2rts.us-east-2.rds.amazonaws.com:5432/postgres";
        String username = "postgres";
        String password = "maxbat15";



        try {
            conn = DriverManager.getConnection(url, username, password);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }


}
