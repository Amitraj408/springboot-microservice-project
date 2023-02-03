package com.amitraj.inventoryservice;

import com.amitraj.inventoryservice.model.Inventoris;
import com.amitraj.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventoris inventory1 = new Inventoris();
			inventory1.setSkuCode("iphone13");
			inventory1.setQuantity(100);

			Inventoris inventory2 = new Inventoris();
			inventory2.setSkuCode("iphone14");
			inventory2.setQuantity(0);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};
	}


}
