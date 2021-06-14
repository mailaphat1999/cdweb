package nlu.project.cdweb.repository;

import nlu.project.cdweb.entity.ForgetPass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForgetPassRepository extends JpaRepository<ForgetPass, String> {

}
