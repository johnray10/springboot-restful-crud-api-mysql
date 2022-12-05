package softengineerjay.springbootrestfulcrudapimysql.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softengineerjay.springbootrestfulcrudapimysql.models.Product;
import softengineerjay.springbootrestfulcrudapimysql.repository.ProductDao;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService  {
    @Autowired
    private ProductDao productDao;

    public List<Product> listAll() {
        return productDao.findAll();
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public Product get(Integer id) {
        return productDao.findById(id).get();
    }

    public void delete(Integer id) {
        productDao.deleteById(id);
    }
}
