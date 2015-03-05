package persistence;

import java.util.List;

public interface TagDao {
    
    public List<Article> getArticlesByTagName(String tag);

}
