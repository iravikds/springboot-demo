package com.ravi.springboot.web;

import com.ravi.springboot.model.Item;
import com.ravi.springboot.model.ItemRepository;
import com.ravi.springboot.web.errors.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/items")
    List<Item> all(){
        return itemRepository.findAll();
    }

    @GetMapping("/items/{id}")
    Item getById(@PathVariable Long id){
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PostMapping("/items")
    Item createNew(@RequestBody Item newItem){
        return itemRepository.save(newItem);
    }
}
