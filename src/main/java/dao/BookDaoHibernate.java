package dao;

import emums.SearchType;
import entity.AuthorEntity;
import entity.BookEntity;
import model.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import utils.DataHelper;

import java.util.List;

/**
 * Created by Vitaliy on 16.11.2017.
 */
public class BookDaoHibernate {

    private Criteria bookCriteria;
    private Criteria authorCriteria;

    public BookDaoHibernate() {
        this.bookCriteria = DataHelper.getDataHelper().getCurrentSession().createCriteria(BookEntity.class);
        this.authorCriteria = DataHelper.getDataHelper().getCurrentSession().createCriteria(AuthorEntity.class);
    }


    public List<BookEntity> getBookList() {
        return bookCriteria.list();
    }


    public List<BookEntity> getBookListByGenreID(int genreID) {
        return bookCriteria.add(Restrictions.eq("genreId", genreID)).list();
    }


    public List<BookEntity> getBookListByFirstLetter(String letter) {
        return bookCriteria.add(Restrictions.like("name", letter, MatchMode.START)).list();
    }

    public List<BookEntity> getListBySearchType(String searchString, SearchType searchType) {
        List<BookEntity> bookList = null;
        if (searchType == SearchType.AUTHOR) {
            List<AuthorEntity> authorList = authorCriteria.add(Restrictions.like("fio", searchString, MatchMode.ANYWHERE)).list();
            for (AuthorEntity author : authorList) {
                for (BookEntity bookEntity : (List<BookEntity>) bookCriteria.add(Restrictions.eq("authorId", author.getId())).list()) {
                    bookList.add(bookEntity);
                }
            }
        }
        if (searchType == SearchType.BOOKNAME) {
            bookList = bookCriteria.add(Restrictions.like("name", searchString, MatchMode.ANYWHERE)).list();
        }
        return bookList;
    }

    public byte[] getBookContent(int bookID) {
        return (byte[]) bookCriteria.setProjection(Projections.property("content")).add(Restrictions.eq("id", bookID)).uniqueResult();
    }
}
