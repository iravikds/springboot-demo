package com.ravi.springboot;

import com.ravi.springboot.model.Item;
import com.ravi.springboot.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Autowired
	ItemRepository itemRepository;

	@Override
	public void run(String... args) throws Exception{
		itemRepository.save(new Item(null, "Item 1"));
	}

}
