package persistence;

public interface ArticleDao {
    
    public Article queryArticleById (int id);
    
    public Article queryArticleByTitle(String title);

}
