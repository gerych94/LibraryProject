package dao;

import model.Genre;
import utils.CloseJNDIConnection;
import utils.JNDIConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaliy on 25.05.2017.
 */
public class GenreDaoJNDI implements IGenreDao {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private List<Genre> genreList=new ArrayList();

    private List<Genre> getAllGenre(){
        try {
            connection= JNDIConnection.getJNDIConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM library.genre");
            while (resultSet.next()){
               Genre genre=new Genre();
                 genre.setId(resultSet.getInt("id"));
                 genre.setGenreName(resultSet.getString("name"));
                genreList.add(genre);
            }
            return genreList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseJNDIConnection.closeConnection(connection,statement,resultSet);
        }
        return genreList;
    }
    @Override
    public List<Genre> getGenreList() {
        if(genreList.isEmpty()){
            return getAllGenre();
        }
        return genreList;
    }
}
