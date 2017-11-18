package service;

import dao.IBookDao;
import emums.SearchType;
import model.Book;

import java.util.List;

/**
 * Created by Vitaliy on 25.05.2017.
 */
public class BookService implements IBookService {

    private IBookDao IbookDao;

    public BookService() {
    }

    public IBookDao getIbookDao() {
        return IbookDao;
    }

    public void setIbookDao(IBookDao IbookDao) {
        this.IbookDao = IbookDao;
    }

    @Override
    public List<Book> getBookList() {
        return IbookDao.getBookList();
    }

    @Override
    public List<Book> getBookListByGenreID(int genreID) {
        return IbookDao.getBookListByGenreID(genreID);
    }

    @Override
    public List<Book> getBookListByFirstLetter(String letter) {
        return IbookDao.getBookListByFirstLetter(letter);
    }

    @Override
    public List<Book> getBookListBySearchType(String searchString, SearchType searchType) {
        return IbookDao.getListBySearchType(searchString, searchType);
    }
}
