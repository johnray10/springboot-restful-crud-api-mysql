package softengineerjay.springbootrestfulcrudapimysql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softengineerjay.springbootrestfulcrudapimysql.models.Product;
import softengineerjay.springbootrestfulcrudapimysql.services.ProductService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    @Autowired private ProductService productService;

    // RESTful API methods for Retrieval operations
    @GetMapping(value = "/products")
    public List<Product> list() {
        return productService.listAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = productService.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Create operation
    @PostMapping(value = "/products")
    public void add(@RequestBody Product product) {
        productService.save(product);
    }

    // RESTful API method for Update operation
    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existProduct = productService.get(id);
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // RESTful API method for Delete operation
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }
}
