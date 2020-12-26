package com.example.citypa.democtyjoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan({"com.example.citypa.democtyjoa.entitys"})

public class DemoctyjoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoctyjoaApplication.class, args);
	}

}
