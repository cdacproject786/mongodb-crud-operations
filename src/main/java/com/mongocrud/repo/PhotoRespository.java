package com.mongocrud.repo;

import com.mongocrud.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRespository extends MongoRepository<Photo,String> {
}
