package org.launchcode.shoppingclothing.models.data;

import org.launchcode.shoppingclothing.models.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CartRepository extends CrudRepository<Cart, Integer> {
//    Cart findByUser_id(String username);
}
