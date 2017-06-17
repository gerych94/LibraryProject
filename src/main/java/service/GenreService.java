package service;

import dao.IGenreDao;
import model.Genre;

import java.util.List;

/**
 * Created by Vitaliy on 25.05.2017.
 */
public class GenreService implements IGenreService {

    private IGenreDao iGenreDao;

    public GenreService(IGenreDao iGenreDao) {
        this.iGenreDao = iGenreDao;
    }


    @Override
    public List<Genre> getGenreList() {
        return iGenreDao.getGenreList();
    }
}
