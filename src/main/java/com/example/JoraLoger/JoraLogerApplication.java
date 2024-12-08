package com.example.JoraLoger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class JoraLogerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoraLogerApplication.class, args);
	}

}
