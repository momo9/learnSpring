package persistence.mapper;

import java.util.List;

import persistence.Article;

public interface TagMapper {

    public List<Article> getArticlesByTag(String tag);
    
}
