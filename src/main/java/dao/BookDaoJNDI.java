package dao;

import emums.SearchType;
import model.Book;
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
public class BookDaoJNDI implements IBookDao {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private List<Book> bookList = new ArrayList();
    private List<Book> bookListByGenreId = new ArrayList();
    private List<Book> bookListByFirstLetter = new ArrayList();
    private List<Book> bookListBySearchType = new ArrayList();

    private List<Book> getAllBook() {
        try {
            connection = JNDIConnection.getJNDIConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM library.book");
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setBookName(resultSet.getString("name"));
                bookList.add(book);
            }
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseJNDIConnection.closeConnection(connection, statement, resultSet);
        }
        return bookList;
    }

    private List<Book> getBookListByIdGenre(int genreID) {
        try {
            connection = JNDIConnection.getJNDIConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT b.name ,b.id ,b.isbn,b.page_count,b.publish_year,a.fio,g.name as genreName," +
                    "p.name as publisherName,b.image FROM library.book b " +
                    "INNER JOIN library.author a ON b.author_id=a.id" +
                    " inner join library.genre g on b.genre_id=g.id" +
                    " inner join library.publisher p on b.publisher_id=p.id" +
                    " where b.genre_id=" + genreID + " group by b.NAME");
            while (resultSet.next()) {
                bookListByGenreId.add(getBook(resultSet));
            }
            return bookListByGenreId;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseJNDIConnection.closeConnection(connection, statement, resultSet);
        }
        return bookListByGenreId;
    }

    private List<Book> getBookListByLetterFirst(String letter) {
        try {
            connection = JNDIConnection.getJNDIConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT b.name ,b.id ,b.isbn,b.page_count,b.publish_year,a.fio,g.name as genreName," +
                    "p.name as publisherName,b.image FROM library.book b " +
                    "INNER JOIN library.author a ON b.author_id=a.id" +
                    " inner join library.genre g on b.genre_id=g.id" +
                    " inner join library.publisher p on b.publisher_id=p.id" +
                    " where substr(b.name,1,1)='" + letter + "' group by b.NAME");
            while (resultSet.next()) {
                bookListByFirstLetter.add(getBook(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseJNDIConnection.closeConnection(connection, statement, resultSet);
        }
        return bookListByFirstLetter;
    }

    private List<Book> getBookListBySearch(String searchString, SearchType searchType) {
        try {
            connection = JNDIConnection.getJNDIConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder("SELECT b.name ,b.id ,b.isbn,b.page_count,b.publish_year,a.fio,g.name as genreName," +
                    "p.name as publisherName,b.image FROM library.book b " +
                    "INNER JOIN library.author a ON b.author_id=a.id" +
                    " inner join library.genre g on b.genre_id=g.id" +
                    " inner join library.publisher p on b.publisher_id=p.id ");
            if (searchType == SearchType.AUTHOR)
                query.append("where lower(a.fio) like '%" + searchString.toLowerCase() + "%' group by b.name ");
            if (searchType == SearchType.BOOKNAME)
                query.append("where lower(b.name) like '%" + searchString.toLowerCase() + "%' group by b.name ");
            resultSet = statement.executeQuery(String.valueOf(query));
            while (resultSet.next()) {
                bookListBySearchType.add(getBook(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseJNDIConnection.closeConnection(connection, statement, resultSet);
        }

        return bookListBySearchType;
    }

    private Book getBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setAuthor(resultSet.getString("fio"));
        book.setBookName(resultSet.getString("name"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setPageCount(resultSet.getInt("page_count"));
        book.setPublishYear(resultSet.getString("publish_year"));
        book.setPublisher(resultSet.getString("publisherName"));
        book.setGenre(resultSet.getString("publisherName"));
        book.setImage(resultSet.getBytes("image"));
        return book;
    }


    @Override
    public List<Book> getBookList() {
        if (bookList.isEmpty()) {
            return getAllBook();
        }
        return bookList;
    }

    @Override
    public List<Book> getBookListByGenreID(int genreID) {
        if (bookListByGenreId.isEmpty()) {
            return getBookListByIdGenre(genreID);
        }
        return bookListByGenreId;
    }

    @Override
    public List<Book> getBookListByFirstLetter(String letter) {
        if (bookListByFirstLetter.isEmpty()) {
            return getBookListByLetterFirst(letter);
        }
        return bookListByFirstLetter;
    }

    @Override
    public List<Book> getListBySearchType(String searchString, SearchType searchType) {
        if (bookListBySearchType.isEmpty()) {
            return getBookListBySearch(searchString, searchType);
        }
        return bookListBySearchType;
    }

    @Override
    public byte[] getBookContent(int bookID) {
        byte[] bytes = null;
        try {
            connection = JNDIConnection.getJNDIConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT b.content from library.book b WHERE  b.id=" + bookID);
            while (resultSet.next()) {
                bytes = resultSet.getBytes("content");
            }
            return bytes;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CloseJNDIConnection.closeConnection(connection, statement, resultSet);
        }
        return bytes;
    }
}
