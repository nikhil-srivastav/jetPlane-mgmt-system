package com.bth.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bth.springboot.model.JetPlane;

@Repository
public interface JetPlaneRepository extends JpaRepository<JetPlane, Long>{

}
