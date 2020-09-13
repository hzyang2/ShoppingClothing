package org.launchcode.shoppingclothing.models.data;

import org.launchcode.shoppingclothing.models.CartItem;
import org.launchcode.shoppingclothing.models.User;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
    Iterable<CartItem> findAllByUser(User user);
}
