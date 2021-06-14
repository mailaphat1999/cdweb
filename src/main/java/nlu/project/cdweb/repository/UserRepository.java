package nlu.project.cdweb.repository;

import nlu.project.cdweb.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nlu.project.cdweb.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2")
    User login(String username, String password);
    @Query("update User u set u.active = '1' WHERE u.email = ?1")
    User active(String email);
    @Query("SELECT u FROM User u WHERE u.email = ?1 and u.active = '1'")
    User getUserByEmail(String email);
}
