package com.qa.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.qa.persistence.domain.StringObject;

public interface IStringRepo extends CrudRepository<StringObject, Long>{

}
