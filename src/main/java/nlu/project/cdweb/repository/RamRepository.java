package nlu.project.cdweb.repository;

import nlu.project.cdweb.entity.Ram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamRepository extends JpaRepository<Ram, String> {

}
