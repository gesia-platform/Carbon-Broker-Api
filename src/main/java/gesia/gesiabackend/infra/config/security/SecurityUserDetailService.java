package gesia.gesiabackend.infra.config.security;

import gesia.gesiabackend.modules.account.Account;
import gesia.gesiabackend.modules.account.AccountRepository;
import gesia.gesiabackend.modules.common.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static gesia.gesiabackend.modules.common.Const.ACCOUNT_NOT_FOUND_ACCOUNT;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        return new SecurityUserDetails(account);
    }
}
