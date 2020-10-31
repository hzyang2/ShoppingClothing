package org.launchcode.shoppingclothing.models.data;

import org.launchcode.shoppingclothing.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query(value = "SELECT * FROM shoppingclothing.product where category = ?1 or brand = ?1 or product_line = ?1 or size = ?1" , nativeQuery = true)
    Iterable<Product> findBySearchText(String search);
    @Query(value = "SELECT * FROM shoppingclothing.product where product_line = ?1 and category = ?2" , nativeQuery = true)
    Iterable<Product> findByProduct_lineAndCategory(String product_line, String category);
}