package com.amitraj.inventoryservice.repository;

import com.amitraj.inventoryservice.model.Inventoris;
import com.amitraj.inventoryservice.model.Inventoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventoris,Long> {

    List<Inventoris> findBySkuCodeIn(List<String> skuCode);
}
