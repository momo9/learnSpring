package bookmarks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by momo9 on 1/14/2015.
 */
public interface AccountRepository extends JpaRepository<Account, Long>{
    Optional<Account> findByUsername(String username);
}
