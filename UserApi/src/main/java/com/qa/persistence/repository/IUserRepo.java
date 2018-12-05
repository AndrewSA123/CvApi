package com.qa.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.qa.peristence.domain.Users;


@Repository
public interface IUserRepo extends PagingAndSortingRepository<Users,Long> {

}
