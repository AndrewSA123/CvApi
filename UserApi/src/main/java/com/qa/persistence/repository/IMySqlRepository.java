package com.qa.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.User;

@Repository
public interface IMySqlRepository extends CrudRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	public Optional<User> getByUserName(@Param("username") String username);

}
