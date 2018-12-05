package com.qa.Consumer.persistence.repository;

import com.qa.Consumer.persistence.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepo extends JpaRepository<Admin, Long> {
}
