package th.or.pao.revenueonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.or.pao.revenueonline.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}
