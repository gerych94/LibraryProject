package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Vitaliy on 26.05.2017.
 */
public class CloseJNDIConnection {


    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(connection!=null) connection.close();
            if(statement!=null) statement.close();
            if(resultSet!=null) resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
