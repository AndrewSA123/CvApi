package com.qa.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.qa.peristence.domain.Users;


@Repository
public interface IUserRepo extends MongoRepository<Users,Long> {

}
