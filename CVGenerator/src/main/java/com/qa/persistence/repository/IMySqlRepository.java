package com.qa.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistence.domain.CV;

@Repository
public interface IMySqlRepository extends CrudRepository<CV, Long>{

}
