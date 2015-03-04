package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import persistence.Article;
import persistence.ArticleDao;

@Controller
public class Index {
    
    @RequestMapping("/new/{val}")
    public String doGet(@PathVariable String val, Model model) {
        model.addAttribute("message", val);
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
    public Article getArticle(@PathVariable int id) {
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
