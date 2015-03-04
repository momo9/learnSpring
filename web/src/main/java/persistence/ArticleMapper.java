package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArticleMapper implements RowMapper<Article> {

    public Article mapRow(ResultSet rs, int arg1) throws SQLException {
        Article article = new Article();
        article.setId(rs.getInt("id"));
        article.setTitle(rs.getString("title"));
        article.setAuthor(rs.getString("name"));
        return article;
    }

}
