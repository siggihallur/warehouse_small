package com.bachelor.warehouse_one.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface InventoryRepository extends JpaRepository<Inventory, Long>
{
    @Transactional
    @Modifying
    @Query("UPDATE Inventory i SET i.quantity = (i.quantity - ?2) WHERE i.product_id = ?1")
    public void decreaseQuantityByProductId(Long productId, int qty);
}
