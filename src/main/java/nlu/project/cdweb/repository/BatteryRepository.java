package nlu.project.cdweb.repository;

import nlu.project.cdweb.entity.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Integer> {

}
