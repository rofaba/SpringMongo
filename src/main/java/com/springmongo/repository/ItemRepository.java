package com.springmongo.repository;

import com.springmongo.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {


    List<Item> findByCategory(String categoria);

    List<Item> findByCountLessThan(int count);


}