package com.amitraj.inventoryservice.controller;

import com.amitraj.inventoryservice.dto.InventoryResponse;
import com.amitraj.inventoryservice.servic.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    //http://localhost:8082/api/inventory/iphone13,iphone14    -pathVariable
    //http://localhost:8082/api/inventory?skuCode=iphone13&skuCode=iphone14   -requestParameter

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }


}
