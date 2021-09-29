package com.poc.contrainte.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.poc.donnee.domain.Candidate;
import com.poc.donnee.dto.CandidateDTO;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

	CandidateDTO candidateToDto(Candidate candidate);

	Candidate DtoToCandidate(CandidateDTO candidateDTO);

	List<CandidateDTO> candidatestoDtos(List<Candidate> candidates);

	default Page<CandidateDTO> toPageCandidateDTO(Page<Candidate> datas, Pageable page) {
		List<CandidateDTO> candidatesDTO = candidatestoDtos(datas.getContent());
		return new PageImpl<>(candidatesDTO, page, datas.getTotalElements());
	}

}
