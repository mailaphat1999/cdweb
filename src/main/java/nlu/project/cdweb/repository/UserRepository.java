package nlu.project.cdweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nlu.project.cdweb.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
