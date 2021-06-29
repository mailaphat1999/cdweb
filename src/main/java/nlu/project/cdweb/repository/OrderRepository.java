package nlu.project.cdweb.repository;

import nlu.project.cdweb.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    @Transactional
    @Modifying
    @Query("update Order o set o.status = '4' WHERE o.id = ?1 ")
    void cancelOrder(String id);
}
