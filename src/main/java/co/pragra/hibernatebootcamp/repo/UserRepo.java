package co.pragra.hibernatebootcamp.repo;

import co.pragra.hibernatebootcamp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAllByLastNameLikeIgnoreCase(String email);
}
