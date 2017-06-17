package utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Vitaliy on 25.05.2017.
 */
public class JNDIConnection {

    private static  InitialContext initialContext;
    private static  DataSource dataSource;
    private static Connection connection;

    static {
        try {
            initialContext=new InitialContext();
            dataSource= (DataSource) initialContext.lookup("jdbc/library");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static Connection getJNDIConnection(){
        try {
            connection=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
