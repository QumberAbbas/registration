package rc.bootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rc.bootsecurity.model.User;

@Repository
public interface IRegisterationRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
}
