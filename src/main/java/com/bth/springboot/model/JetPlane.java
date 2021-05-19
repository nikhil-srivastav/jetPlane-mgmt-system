package com.bth.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class JetPlane {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "model_name")
	private String modelName;
	
	@Column(name = "manufacturer_name")
	private String manufacturerName;
	
	@Column(name = "jetplane_id")
	private String jetPlaneId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public String getJetPlaneId() {
		return jetPlaneId;
	}
	public void setJetPlaneId(String jetPlaneId) {
		this.jetPlaneId = jetPlaneId;
	}

}
