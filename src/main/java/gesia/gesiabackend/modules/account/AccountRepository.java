package gesia.gesiabackend.modules.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByUsername(String username);

    boolean existsByAccountTypeAndAccountInfoBusinessNumber(AccountType accountType, String businessNumber);

    Optional<Account> findByAccountTypeAndAccountInfoBusinessNumber(AccountType accountType, String businessNumber);

    Optional<Account> findByAccountTypeAndUsernameAndAccountInfoBusinessNumber(AccountType accountType, String username, String businessNumber);

    Optional<Account> findByUsername(String username);

    Optional<Account> findById(Long id);
}
