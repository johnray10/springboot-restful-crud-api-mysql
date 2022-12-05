package softengineerjay.springbootrestfulcrudapimysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softengineerjay.springbootrestfulcrudapimysql.models.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
}
