package bookmarks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by momo9 on 1/14/2015.
 */
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Collection<Bookmark> findByAccountUsername(String username);
}
