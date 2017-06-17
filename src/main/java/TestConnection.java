import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Vitaliy on 06.05.2017.
 */
public class TestConnection {
    public void check(){
        Logger logger=Logger.getLogger(TestConnection.class.getName());
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("jdbc/library");
            Connection connection = dataSource.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM book");
            while (resultSet.next()){
                logger.info(resultSet.getString("name"));
            }
            logger.info("ddddd");
        } catch (SQLException e) {
               logger.log(Level.SEVERE,null,e);
        }
         catch (NamingException e) {
            logger.log(Level.SEVERE,null,e);
        }
    }
}
