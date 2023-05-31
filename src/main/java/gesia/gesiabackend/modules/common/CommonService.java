package gesia.gesiabackend.modules.common;

import gesia.gesiabackend.modules.account.Account;
import gesia.gesiabackend.modules.account.AccountRepository;
import gesia.gesiabackend.modules.common.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static gesia.gesiabackend.modules.common.Const.ACCOUNT_NOT_FOUND_ACCOUNT;
import static gesia.gesiabackend.modules.common.Const.ACCOUNT_WITHDRAWAL_ACCOUNT;

@Service
@RequiredArgsConstructor
public class CommonService {

    private final AccountRepository accountRepository;

    public void checkWithdrawalAccount(String username) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        if (account.isWithdrawalAccount()) {
            throw new BadRequestException(ACCOUNT_WITHDRAWAL_ACCOUNT);
        }
    }
}
