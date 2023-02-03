package com.amitraj.inventoryservice.servic;

import com.amitraj.inventoryservice.dto.InventoryResponse;
import com.amitraj.inventoryservice.repository.InventoryRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        log.info("wait started");
        Thread.sleep(10000);
        log.info("wait ended");
    return inventoryRepository.findBySkuCodeIn(skuCode)
            .stream()
            .map(inventoris -> InventoryResponse.builder()
                    .skuCode(inventoris.getSkuCode())
                    .isInStock(inventoris.getQuantity()>0)
                    .build())
            .toList();

    }
}
