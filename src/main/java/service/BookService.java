package service;

import dao.IBookDao;
import emums.SearchType;
import model.Book;

import java.util.List;

/**
 * Created by Vitaliy on 25.05.2017.
 */
public class BookService implements IBookService {

    private IBookDao iBookDao;

    public BookService(IBookDao iBookDao){
        this.iBookDao=iBookDao;
    }

    @Override
    public List<Book> getBookList() {
        return iBookDao.getBookList();
    }

    @Override
    public List<Book> getBookListByGenreID(int genreID) {
        return iBookDao.getBookListByGenreID(genreID);
    }

    @Override
    public List<Book> getBookListByFirstLetter(String letter) {
        return iBookDao.getBookListByFirstLetter(letter);
    }

    @Override
    public List<Book> getBookListBySearchType(String searchString, SearchType searchType) {
        return iBookDao.getListBySearchType(searchString,searchType);
    }
}
