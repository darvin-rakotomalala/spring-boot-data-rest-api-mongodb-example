package com.poc.infrastructure;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.donnee.dto.CandidateDTO;
import com.poc.service.metier.CandidateSM;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	@Autowired
	private CandidateSM candidateSM;
	
	@Operation(summary = "add candidate")
	@PostMapping("/add")
	public CandidateDTO addCandidate(@RequestBody CandidateDTO candidateDTO) {
		return candidateSM.create(candidateDTO);
	}

	@Operation(summary = "update candidate")
	@PutMapping(value = "/update")
	public CandidateDTO updateCandidate(HttpServletResponse response, @RequestBody CandidateDTO candidateDTO) {
		return candidateSM.update(candidateDTO);
	}
	
	@Operation(summary = "delete candidate")
	@DeleteMapping(value = "/delete/{id}")
	public CandidateDTO deleteCandidate(@PathVariable("id") String id) {
		return candidateSM.delete(id);
	}
	
	@Operation(summary = "find all candidates")
	@GetMapping(value = "/findall")
	public List<CandidateDTO> findAllCandidates(HttpServletRequest httpServletRequest) {
		return candidateSM.findAll();
	}

	@Operation(summary = "find candidate by Id")
	@GetMapping(value = "/get/{id}")
	public CandidateDTO getCandidateById(@PathVariable("id") String id) {
		return candidateSM.getCandidateById(id);
	}

	@Operation(summary = "Delete all post")
	@DeleteMapping("/deleteall")
	public CandidateDTO deleteAllCandidates() {
		return candidateSM.deleteAll();
	}
	
	@Operation(summary = "get list candidates pagined")
	@GetMapping(path = "/listpagined")
	public Page<CandidateDTO> getListCandidates(@PageableDefault(page = 0, size = 5) Pageable page) {
		return candidateSM.findAllPageCandidate(page);
	}

	@Operation(summary = "find candidates pagined by name")
	@GetMapping(path = "/findByName")
	public Page<CandidateDTO> findByNameCandidate(
			@RequestParam(defaultValue = "") String name, 
			@PageableDefault(page = 0, size = 5) Pageable page) {
		return candidateSM.findByName(name, page);
	}
	
	@Operation(summary = "find candidate by email")
	@GetMapping(value = "/findByEmail")
	public CandidateDTO findByEmailCandidate(@RequestParam(defaultValue = "") String email) {
		return candidateSM.findByEmail(email);
	}
	
	@Operation(summary = "find candidates by exp")
	@GetMapping(value = "/findByExp")
	public List<CandidateDTO> findByExpGreaterThanEqual(@RequestParam(defaultValue = "") double exp) {
		return candidateSM.findByExpGreaterThanEqual(exp);
	}
	
	@Operation(summary = "find candidates by exp between")
	@GetMapping(value = "/findByExpBetween")
	public List<CandidateDTO> findByExpBetween(@RequestParam double from, @RequestParam double to) {
		return candidateSM.findByExpBetween(from, to);
	}
}
