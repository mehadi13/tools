package com.bjit.training.employee.model;

public class PageInfo {

	private int page;
	private int size;
	private int numberOfElement;
	private long totalElement;
	private int totalPages;

	public PageInfo() {
		super();
	}

	public PageInfo(int page, int size, int numberOfElement, long totalElement, int totalPages) {
		super();
		this.page = page;
		this.size = size;
		this.numberOfElement = numberOfElement;
		this.totalElement = totalElement;
		this.totalPages = totalPages;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTotalElement() {
		return totalElement;
	}

	public void setTotalElement(int totalElement) {
		this.totalElement = totalElement;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getNumberOfElement() {
		return numberOfElement;
	}

	public void setNumberOfElement(int numberOfElement) {
		this.numberOfElement = numberOfElement;
	}

}
