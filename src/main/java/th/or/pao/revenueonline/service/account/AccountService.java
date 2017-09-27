package th.or.pao.revenueonline.service.account;

import th.or.pao.revenueonline.model.Account;

import java.util.List;

public interface AccountService {

    Account findById(Long id);

    Account findByName(String name);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccountById(Long id);

    void deleteAllAccounts();

    List<Account> findAllAccounts();

    boolean isAccountExist(Account account);
}