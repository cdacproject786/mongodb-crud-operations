package com.mongocrud.repo;

import com.mongocrud.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,Long> {
}
