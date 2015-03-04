package persistence;

public interface AuthorDao {
    
    public Integer createAuthor(Author author);
    
    public Author queryAuthorByName(String name);

}
