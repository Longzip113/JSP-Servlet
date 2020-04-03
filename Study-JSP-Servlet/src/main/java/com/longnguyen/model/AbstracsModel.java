package com.longnguyen.model;

import java.sql.Timestamp;

public class AbstracsModel {

	private long id;
	private Timestamp createdData;
	private Timestamp modifiedData;
	private String createdBy;
	private String modifiedBy;
	
	
	
	
	public Timestamp getCreatedData() {
		return createdData;
	}
	public void setCreatedData(Timestamp createdData) {
		this.createdData = createdData;
	}
	public Timestamp getModifiedData() {
		return modifiedData;
	}
	public void setModifiedData(Timestamp modifiedData) {
		this.modifiedData = modifiedData;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
