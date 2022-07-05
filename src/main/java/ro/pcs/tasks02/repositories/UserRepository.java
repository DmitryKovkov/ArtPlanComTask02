package ro.pcs.tasks02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.pcs.tasks02.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
