package com.acacias_del_mar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcaciasDelMarApplication {

	public static void main(String[] args) {
            SpringApplication.run(AcaciasDelMarApplication.class, args);
            System.out.println("==============================================");
            System.out.println("Acacias del mar");
            System.out.println("URL: http://localhost:8080/acaciasDelMar");
            System.out.println("API REST: http://localhost:8080/acaciasDelMar/api");
            System.out.println("==============================================");
	}

}
