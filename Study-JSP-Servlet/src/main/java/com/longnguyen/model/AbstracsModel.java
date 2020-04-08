package com.longnguyen.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstracsModel<T> {

	private long id;
	private Timestamp createdData;
	private Timestamp modifiedData;
	private String createdBy;
	private String modifiedBy;
	private Long[] ids;
	private List<T> listResult = new ArrayList<>();
	private Integer page;
	private Integer maxPageItem; //So item tren mot page
	private Integer totalPage; // tong so page
	private Integer totalItem; // tong so page
	
	
	
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
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	
	
	
}
