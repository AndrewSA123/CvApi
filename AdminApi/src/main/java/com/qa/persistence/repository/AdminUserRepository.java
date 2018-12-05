package com.qa.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qa.persistence.domain.AdminUser;

public interface AdminUserRepository extends MongoRepository<AdminUser, Long> {

}
