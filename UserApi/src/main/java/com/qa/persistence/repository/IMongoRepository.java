package com.qa.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.User;

@Repository
public interface IMongoRepository extends MongoRepository<User, Long> {

}
