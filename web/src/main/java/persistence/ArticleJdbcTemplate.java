package persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ArticleJdbcTemplate implements ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Article queryArticleById(int id) throws EmptyResultDataAccessException {

        String sql = "select ar.id, ar.title, au.name "
                + "from articles as ar, authors as au "
                + "where ar.authorId = au.id " + "and ar.id = ?;";
        
        return jdbcTemplate.queryForObject(sql, new Object[] { id },
                new ArticleMapper());
    }

    public Article queryArticleByTitle(String title) {
        // TODO Auto-generated method stub
        return null;
    }

}
