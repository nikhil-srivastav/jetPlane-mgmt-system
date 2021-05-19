package com.bth.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bth.springboot.model.JetPlane;

public interface JetplaneService {
	List<JetPlane> getAllJetPlanes();
	void saveJetPlane(JetPlane jetPlane);
	JetPlane getJetPlaneById(long id);
	void deleteJetPlaneById(long id);
	Page<JetPlane> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
