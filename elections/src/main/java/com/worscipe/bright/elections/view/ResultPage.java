package com.worscipe.bright.elections.view;

import java.io.Serializable;
import java.util.List;


/**
 * Page is an class providing common pagination properties for a target view object for front-end pagination.
 * @author matthew.b.dowell
 * 
 * @param <T>
 */
public class ResultPage<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4727194050520724863L;
	public Integer totalResultingPages;
	public Integer currentPageNum;
	public Integer  numValuesCurrentPage;
	private Integer numValuesPerPageLimit; 
	private List<T> valuesList;
	public Long totalResultCount;
	
	
	public Long getTotalResultCount() {
		return totalResultCount;
	}
	public void setTotalResultCount(Long totalResultCount) {
		this.totalResultCount = totalResultCount;
	}
	public Integer getTotalResultingPages() {
		return totalResultingPages;
	}
	public void setTotalResultingPages(Integer totalResultingPages) {
		this.totalResultingPages = totalResultingPages;
	}
	public Integer getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(Integer currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public Integer getNumValuesCurrentPage() {
		return numValuesCurrentPage;
	}
	public void setNumValuesCurrentPage(Integer numValuesCurrentPage) {
		this.numValuesCurrentPage = numValuesCurrentPage;
	}
	public Integer getNumValuesPerPageLimit() {
		return numValuesPerPageLimit;
	}
	public void setNumValuesPerPageLimit(Integer numValuesPerPageLimit) {
		this.numValuesPerPageLimit = numValuesPerPageLimit;
	}
	public List<T> getValuesList() {
		return valuesList;
	}
	public void setValuesList(List<T> valuesList) {
		this.valuesList = valuesList;
	}

	 
    
	
}
