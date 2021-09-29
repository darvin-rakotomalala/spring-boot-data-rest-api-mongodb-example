package com.poc.service.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.poc.donnee.dto.CandidateDTO;

public interface CandidateSM {

	CandidateDTO create(CandidateDTO candidateDTO);

	CandidateDTO delete(String id);

	CandidateDTO deleteAll();

	CandidateDTO update(CandidateDTO candidateDTO);
	
	List<CandidateDTO> findAll();

	CandidateDTO getCandidateById(String id);
		
	Page<CandidateDTO> findAllPageCandidate(Pageable page);

	Page<CandidateDTO> findByName(String name, Pageable page);
	
	// Custom Query Methods
	CandidateDTO findByEmail(String email);
	
	List<CandidateDTO> findByExpGreaterThanEqual(double exp);
	
	List<CandidateDTO> findByExpBetween(double from, double to);
}
