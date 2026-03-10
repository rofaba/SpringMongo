package com.springmongo.repository;

import com.springmongo.model.ItemsResumen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
public interface ItemResumenRepository extends MongoRepository<ItemsResumen, String> {

}