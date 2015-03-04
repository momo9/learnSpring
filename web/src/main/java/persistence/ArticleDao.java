package persistence;

public interface ArticleDao {
    
    public Article queryArticleById (Integer id);
    
    public Article queryArticleByTitle(String title);

}
