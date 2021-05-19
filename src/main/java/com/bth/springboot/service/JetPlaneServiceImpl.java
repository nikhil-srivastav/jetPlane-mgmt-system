package com.bth.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bth.springboot.model.JetPlane;
import com.bth.springboot.repository.JetPlaneRepository;

@Service
public class JetPlaneServiceImpl implements JetplaneService {

	@Autowired
	private JetPlaneRepository jetPlaneRepository;

	@Override
	public List<JetPlane> getAllJetPlanes() {
		return jetPlaneRepository.findAll();
	}

	@Override
	public void saveJetPlane(JetPlane jetPlane) {
		this.jetPlaneRepository.save(jetPlane);
	}

	@Override
	public JetPlane getJetPlaneById(long id) {
		Optional<JetPlane> optional = jetPlaneRepository.findById(id);
		JetPlane jetPlane = null;
		if (optional.isPresent()) {
			jetPlane = optional.get();
		} else {
			throw new RuntimeException(" JetPlane not found for id :: " + id);
		}
		return jetPlane;
	}

	@Override
	public void deleteJetPlaneById(long id) {
		this.jetPlaneRepository.deleteById(id);
	}

	@Override
	public Page<JetPlane> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.jetPlaneRepository.findAll(pageable);
	}
}
