package dao;

import emums.SearchType;
import model.Book;

import java.util.List;

/**
 * Created by Vitaliy on 25.05.2017.
 */
public interface IBookDao {

    List<Book> getBookList();

    List<Book> getBookListByGenreID(int genreID);

    List<Book> getBookListByFirstLetter(String letter);

    List<Book> getListBySearchType(String searchString, SearchType searchType);

    byte[] getBookContent(int bookID);


}
