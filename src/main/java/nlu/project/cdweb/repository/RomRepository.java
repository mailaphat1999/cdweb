package nlu.project.cdweb.repository;

import nlu.project.cdweb.entity.Rom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RomRepository extends JpaRepository<Rom, String> {

}
