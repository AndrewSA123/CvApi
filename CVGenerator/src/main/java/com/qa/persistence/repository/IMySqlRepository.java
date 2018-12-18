package com.qa.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.CV;

@Repository
public interface IMySqlRepository extends JpaRepository<CV, Long>{
	
	@Query("SELECT c FROM CV c WHERE c.user_id = :user_id")
	public Optional<CV> getCvByUser(@Param("user_id") Long user_id);

}
