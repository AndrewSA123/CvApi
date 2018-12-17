package com.qa.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.ProfilePicture;

@Repository
public interface IMySqlRepo extends CrudRepository<ProfilePicture, Long> {

	@Query("SELECT p FROM ProfilePicture p WHERE p.user_id = :user_id")
	public Optional<ProfilePicture> findPictureByUser(@Param("user_id") Long user_id);

}
