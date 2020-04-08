package com.longnguyen.paging;

import com.longnguyen.sort.Sorter;

public class pageRequest implements Pageble{

	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;
	
	public pageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		super();
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}
	
	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	

	@Override
	public Integer getOffset() {
		if(this.page != null && this.maxPageItem != null)
		return (this.page - 1) * this.maxPageItem;
		return null;
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.maxPageItem;
	}

	@Override
	public Sorter getSorter() {
		if(this.sorter != null)
		return this.sorter;
		return null;
	}

}
