package bookmarks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by momo9 on 1/14/2015.
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    @Bean
    CommandLineRunner init(AccountRepository accountRepository,
                           BookmarkRepository bookmarkRepository) {
        return (evt) -> Arrays.asList("Momo", "Mona").forEach(
                a -> {
                    Account account = accountRepository.save(new Account(a, a.toLowerCase()));
                    bookmarkRepository.save(new Bookmark(
                                    account,
                                    String.format("http://momo9.me/%s/1", a),
                                    "first")
                    );
                    bookmarkRepository.save(new Bookmark(
                                    account,
                                    String.format("http://momo9.me/%s/2", a),
                                    "second")
                    );
                }
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

@RestController
@RequestMapping("/hello")
class HelloController {
    @RequestMapping("")
    Name hello() {
        return new Name("Chenchi", "Liang");
    }
}

@RestController
class BookmarkRestController {

    private final BookmarkRepository bookmarkRepository;

    private final AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}/add")
    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Bookmark input) {
        this.validateUser(userId);
        return this.accountRepository.findByUsername(userId).map(
                account -> {
                    Bookmark result = bookmarkRepository.save(new Bookmark(account,
                            input.uri, input.description));

                    HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.setLocation(
                            ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}").buildAndExpand(result.getId()).toUri()
                    );
                    return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
                }).get();

    }

    @RequestMapping(value = "/bookmarks/{bookmarkId}", method = RequestMethod.GET)
    Bookmark readBookmark(@PathVariable Long bookmarkId) {
        return this.bookmarkRepository.findOne(bookmarkId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/bookmarks")
    Collection<Bookmark> readBookmarks(@PathVariable String userId) {
        this.validateUser(userId);
        return this.bookmarkRepository.findByAccountUsername(userId);
    }

    @Autowired
    BookmarkRestController(BookmarkRepository bookmarkRepository,
                           AccountRepository accountRepository) {
        this.bookmarkRepository = bookmarkRepository;
        this.accountRepository = accountRepository;
    }

    private void validateUser(String userId) {
        this.accountRepository.findByUsername(userId).orElseThrow(
                () -> new UserNotFoundException(userId));
    }
}


@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userId) {
        super("could not find user '" + userId + "'.");
    }

}
