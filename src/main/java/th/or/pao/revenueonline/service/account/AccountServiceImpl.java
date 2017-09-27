package th.or.pao.revenueonline.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import th.or.pao.revenueonline.model.Account;
import th.or.pao.revenueonline.repositories.account.AccountRepository;

import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account findById(Long id) {
        return accountRepository.findOne(id);
    }

    public Account findByName(String name) {
        return accountRepository.findByName(name);
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public void updateAccount(Account account) {
        saveAccount(account);
    }

    public void deleteAccountById(Long id) {
        accountRepository.delete(id);
    }

    public void deleteAllAccounts() {
        accountRepository.deleteAll();
    }

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    public boolean isAccountExist(Account account) {
        return findByName(account.getAccountName()) != null;
    }

}