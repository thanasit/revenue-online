package th.or.pao.revenueonline.repositories.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.or.pao.revenueonline.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByName(String name);

}
