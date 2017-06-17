package service;

import dao.IAuthorDao;
import model.Author;

import java.util.List;

/**
 * Created by Vitaliy on 25.05.2017.
 */
public class AuthorService  implements IAuthorService{

    private IAuthorDao iAuthorDao;

    public AuthorService(){}

    public AuthorService(IAuthorDao iAuthorDao){
        this.iAuthorDao=iAuthorDao;
    }

    @Override
    public List<Author> getAllAuthors() {
        return iAuthorDao.getAuthorList();
    }
}
