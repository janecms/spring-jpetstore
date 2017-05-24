package com.hellojd.jpetstore.domain.model;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
public interface ICart {
    Iterator<CartItem> getCartItems();

    List<CartItem> getCartItemList();

    int getNumberOfItems();

    Iterator<CartItem> getAllCartItems();

    boolean containsItemId(String itemId);

    void addItem(Item item, boolean isInStock);

    Item removeItemById(String itemId);

    void incrementQuantityByItemId(String itemId);

    void setQuantityByItemId(String itemId, int quantity);

    BigDecimal getSubTotal();
}
