/** 
 * PagingResult.java Create on 2017年12月21日
 */ 


package com.sixteenkm.api.bean;

import java.util.List;

import com.sixteenkm.api.jdbc.paging.Paging;

/**
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.0.0
 * @date 2017年12月21日
 */
public class PagingResult<T> {
	
	private List<T> rows;
	private long total;
	
	public PagingResult(Paging<T> paging) {
        rows = paging.getItemList();
        total = paging.getTotalCount();
    }

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
