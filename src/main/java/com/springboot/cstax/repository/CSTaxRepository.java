package com.springboot.cstax.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.cstax.dto.PIDummyCollection;

public interface CSTaxRepository extends MongoRepository<PIDummyCollection,String> {

}
