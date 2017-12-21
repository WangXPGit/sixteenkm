/** 
 * Paging.java Create on 2017年12月21日
 */

package com.sixteenkm.api.jdbc.paging;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.1.1
 * @date 2017年12月21日
 */
public class Paging<T> {

	private int pageNumber;

	private int pageSize;

	private long pageCount;

	private long totalCount;

	private List<T> itemList;

	public Paging(int pageNumber, int pageSize, long totalCount,
			List<T> itemList) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.itemList = itemList;
		if (pageSize != 0) {
			if (totalCount % pageSize == 0) {
				pageCount = totalCount / pageSize;
			} else {
				pageCount = totalCount / pageSize + 1;
			}
		}
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public long getPageCount() {
		return pageCount;
	}

	public long getTotalCount() {
		return totalCount;
	}

	@JsonProperty("has_prev_page")
	public boolean hasPrevPage() {
		return pageNumber > 1 && pageNumber <= pageCount;
	}

	@JsonProperty("has_next_page")
	public boolean hasNextPage() {
		return pageNumber < pageCount;
	}

	@JsonProperty("is_first_page")
	public boolean isFirstPage() {
		return pageNumber == 1;
	}

	@JsonProperty("is_last_page")
	public boolean isLastPage() {
		return pageNumber == pageCount;
	}

	public List<T> getItemList() {
		return itemList;
	}
}
