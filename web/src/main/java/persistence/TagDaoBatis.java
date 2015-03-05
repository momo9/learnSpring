package persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import persistence.mapper.TagMapper;

@Component
public class TagDaoBatis implements TagDao {
    
    @Autowired
    private TagMapper mapper;

    public List<Article> getArticlesByTagName(String tag) {
        List<Article> articles = mapper.getArticlesByTag(tag);
        if (articles.isEmpty()) {
            throw new EmptyResultDataAccessException(0);
        } else {
            return articles;
        }
    }

}
