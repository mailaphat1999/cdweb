package nlu.project.cdweb.repository;

import nlu.project.cdweb.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p FROM Product p WHERE p.status = ?1 ")
    List<Product> homeProducts(String status,Pageable pageable);
    @Query("SELECT p FROM Product p WHERE p.price > ?1 and p.price < ?2")
    List<Product> priceProducts(int start,int end);
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%',:search,'%')")
    List<Product> search(@Param("search") String search);
}
