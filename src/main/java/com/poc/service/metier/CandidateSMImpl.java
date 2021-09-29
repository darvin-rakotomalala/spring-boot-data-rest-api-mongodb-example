package com.poc.service.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poc.contrainte.error.ErrorsEnum;
import com.poc.contrainte.error.FunctionalException;
import com.poc.contrainte.mapper.CandidateMapper;
import com.poc.donnee.domain.Candidate;
import com.poc.donnee.dto.CandidateDTO;
import com.poc.service.repository.CandidateRepository;

@Service
public class CandidateSMImpl implements CandidateSM {

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private CandidateMapper candidateMapper;

	@Override
	public CandidateDTO create(CandidateDTO candidateDTO) {
		return candidateMapper.candidateToDto(candidateRepository.save(candidateMapper.DtoToCandidate(candidateDTO)));
	}

	@Override
	public CandidateDTO delete(String id) {
		Optional<Candidate> candidate = candidateRepository.findById(id);
		if (!candidate.isPresent()) {
			throw new FunctionalException(ErrorsEnum.ERR_ID_CANDIDATE);
		}
		candidateRepository.deleteById(id);
		return candidateMapper.candidateToDto(candidate.get());
	}

	@Override
	public CandidateDTO deleteAll() {
		candidateRepository.deleteAll();
		return null;
	}

	@Override
	public CandidateDTO update(CandidateDTO candidateDTO) {
		Optional<Candidate> candidate = candidateRepository.findById(candidateDTO.getId());
		if (candidate.isPresent()) {
			return candidateMapper
					.candidateToDto(candidateRepository.save(candidateMapper.DtoToCandidate(candidateDTO)));
		}
		throw new FunctionalException(ErrorsEnum.ERR_ID_CANDIDATE);
	}

	@Override
	public List<CandidateDTO> findAll() {
		List<Candidate> list = candidateRepository.findAll();
		List<CandidateDTO> listDto;
		if (!list.isEmpty()) {
			listDto = candidateMapper.candidatestoDtos(list);
			return listDto;
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public CandidateDTO getCandidateById(String id) {
		Optional<Candidate> candidate = candidateRepository.findById(id);
		if (!candidate.isPresent()) {
			throw new FunctionalException(ErrorsEnum.ERR_ID_CANDIDATE);
		}
		return candidateMapper.candidateToDto(candidate.get());
	}

	@Override
	public Page<CandidateDTO> findAllPageCandidate(Pageable page) {
		Page<Candidate> candidates = candidateRepository.findAll(page);
		return candidateMapper.toPageCandidateDTO(candidates, page);
	}

	@Override
	public Page<CandidateDTO> findByName(String name, Pageable page) {
		Page<Candidate> candidates = candidateRepository.findByNameIgnoreCase(name, page);
		return candidateMapper.toPageCandidateDTO(candidates, page);
	}

	@Override
	public CandidateDTO findByEmail(String email) {
		Candidate candidate = candidateRepository.findByEmail(email);
		if (candidate != null) {
			return candidateMapper.candidateToDto(candidate);
		}
		return null;
	}

	@Override
	public List<CandidateDTO> findByExpGreaterThanEqual(double exp) {
		List<Candidate> candidate = candidateRepository.findByExpGreaterThanEqual(exp);
		if (candidate != null) {
			return candidateMapper.candidatestoDtos(candidate);
		}
		return null;
	}

	@Override
	public List<CandidateDTO> findByExpBetween(double from, double to) {
		List<Candidate> candidate = candidateRepository.findByExpBetween(from, to);
		if (candidate != null) {
			return candidateMapper.candidatestoDtos(candidate);
		}
		return null;
	}

}
