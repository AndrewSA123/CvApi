package com.qa.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.User;
@Repository
public interface IUserRepo extends CrudRepository<User, Long>{

}
