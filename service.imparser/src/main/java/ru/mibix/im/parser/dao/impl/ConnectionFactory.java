package ru.mibix.im.parser.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{
    private static final Logger log = LogManager.getLogger(ConnectionFactory.class.getName());

    //static reference to itself
    private static ConnectionFactory instance = new ConnectionFactory();
    public static final String URL = "jdbc:mysql://localhost:3306/imparser";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    //private constructor
    private ConnectionFactory()
    {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection()
    {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            log.error("Unable to Connect to Database.");
        }
        return connection;
    }

    public static Connection getConnection()
    {
        return instance.createConnection();
    }
}
