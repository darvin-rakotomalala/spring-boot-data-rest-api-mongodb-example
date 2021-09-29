package com.poc.service.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc.donnee.domain.Candidate;

public interface CandidateRepository extends MongoRepository<Candidate, String> {

	Page<Candidate> findAll(Pageable page);

	Page<Candidate> findByNameIgnoreCase(String name, Pageable page);

	// Custom Query Methods
	Candidate findByEmail(String email);

	List<Candidate> findByExpGreaterThanEqual(double exp);

	List<Candidate> findByExpBetween(double from, double to);
}
