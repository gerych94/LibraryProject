package dao;

import entity.AuthorEntity;
import entity.GenreEntity;
import model.Genre;
import org.hibernate.Criteria;
import utils.DataHelper;

import java.util.List;

/**
 * Created by Vitaliy on 16.11.2017.
 */
public class GenreDaoHibernate {

    private Criteria genreCriteria;

    public GenreDaoHibernate() {
        this.genreCriteria = DataHelper.getDataHelper().getCurrentSession().createCriteria(AuthorEntity.class);
    }

    public List<GenreEntity> getGenreList() {
        return genreCriteria.list();
    }
}
