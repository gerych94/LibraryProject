package service;

import emums.SearchType;
import model.Book;

import java.util.List;

/**
 * Created by Vitaliy on 25.05.2017.
 */
public interface IBookService  {

     List<Book> getBookList();

     List<Book> getBookListByGenreID(int genreID);

    List<Book> getBookListByFirstLetter(String letter);

    List<Book> getBookListBySearchType(String searchString, SearchType searchType);


}
