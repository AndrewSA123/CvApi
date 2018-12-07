package com.qa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.domain.CVEntity;

public interface CVEntityRepo extends JpaRepository<CVEntity, Long> {
}
