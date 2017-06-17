package dao;

import model.Author;
import utils.CloseJNDIConnection;
import utils.JNDIConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaliy on 25.05.2017.
 */
public class AuthorDaoJNDI implements IAuthorDao {

     private Connection connection;
     private Statement statement;
     private ResultSet resultSet;
     private final List<Author> authorList=new ArrayList<Author>();

    public AuthorDaoJNDI(){
    }
    private List<Author> getAllAuthors() {
        try {
            connection=JNDIConnection.getJNDIConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM library.author ORDER BY fio ASC");
            while (resultSet.next()){
                Author author=new Author();
                author.setId(resultSet.getInt("id"));
                author.setFio(resultSet.getString("fio"));
                author.setBirthday(resultSet.getString("birthday"));
                authorList.add(author);
            }
            return authorList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            CloseJNDIConnection.closeConnection(connection,statement,resultSet);
        }
        return authorList;
    }
    @Override
    public List<Author> getAuthorList(){
        if(authorList.isEmpty()){
            return getAllAuthors();
        }
        return authorList;
    }
}
