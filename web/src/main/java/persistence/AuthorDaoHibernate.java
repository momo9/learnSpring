package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Component
public class AuthorDaoHibernate implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Integer createAuthor(Author author) {
        Session session = sessionFactory.openSession();
        Integer id = (Integer) session.save(author);
        session.close();
        return id;
    }

    public Author queryAuthorByName(String name) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Author.class);
        criteria.add(Restrictions.eq("name", name));
        List<Author> authors = criteria.list();
        session.close();
        if (authors.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        } else {
            return authors.get(0);            
        }
    }

}
