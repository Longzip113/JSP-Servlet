package com.longnguyen.model;

public class NewModel extends AbstracsModel<NewModel>{


	private String title;
	private String thumbnail;
	private String shortDescripTion;
	private String content;
	private long categoryId;
	private String categoryCode;

	
	
	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescripTion() {
		return shortDescripTion;
	}
	public void setShortDescripTion(String shortDescripTion) {
		this.shortDescripTion = shortDescripTion;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

}
