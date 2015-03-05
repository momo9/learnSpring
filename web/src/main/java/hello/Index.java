package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import persistence.Article;
import persistence.ArticleDao;
import persistence.Author;
import persistence.AuthorDao;
import persistence.TagDao;

@Controller
public class Index {

    @Autowired
    private TagDao tagDao;

    @RequestMapping("/tag/{name}")
    public String tag(@PathVariable String name, Model model) {
        List<Article> articles;

        try {
            articles = tagDao.getArticlesByTagName(name);
        } catch (EmptyResultDataAccessException e) {
            return "/notFound";
        }
        model.addAttribute("articles", articles);
        model.addAttribute("tag", name);
        return "/tag";
    }

    @Autowired
    private AuthorDao authorDao;

    @RequestMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Author doGet(@RequestParam String name) {
        Author author = new Author();
        author.setName(name);
        Integer id = authorDao.createAuthor(author);
        author.setId(id);
        return author;
    }

    @RequestMapping("/show/{name}")
    public String show(@PathVariable String name, Model model) {
        Author author;
        try {
            author = authorDao.queryAuthorByName(name);
        } catch (EmptyResultDataAccessException e) {
            return "/notFound";
        }
        model.addAttribute("id", author.getId());
        model.addAttribute("name", author.getName());
        return "/show";
    }

    @RequestMapping(value = "/json/{val}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message json(@PathVariable String val) {
        return new Message(val);
    }

    @Autowired
    private ArticleDao dao;

    @RequestMapping(value = "/articles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Article getArticle(@PathVariable Integer id) {
        Article article;
        try {
            article = dao.queryArticleById(id);
        } catch (EmptyResultDataAccessException e) {
            article = new Article();
            article.setId(id);
            article.setTitle("N/A");
            article.setAuthor("N/A");
        }
        return article;
    }

}
