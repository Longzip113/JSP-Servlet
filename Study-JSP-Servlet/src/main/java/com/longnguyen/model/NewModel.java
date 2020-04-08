package com.longnguyen.model;

public class NewModel extends AbstracsModel<NewModel>{


	private String title;
	private String thumbnuil;
	private String shortDescripTion;
	private String content;
	private long categoryId;

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnuil() {
		return thumbnuil;
	}
	public void setThumbnuil(String thumbnuil) {
		this.thumbnuil = thumbnuil;
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
