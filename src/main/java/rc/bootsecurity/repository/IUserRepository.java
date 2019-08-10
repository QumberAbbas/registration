package rc.bootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rc.bootsecurity.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUserName(String name);
}
