/** 
 * PagingParam.java Create on 2017-12-21
 */ 


package com.sixteenkm.api.bean;

import com.sixteenkm.api.util.StringUtil;

/**
 * 分页参数对象
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.1.1
 * @date 2017-12-21
 */
public class PagingParam {

	private int offset;
    private int limit;
    private String search;
    private String sort;
    private String order;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }


    public int getPagingNumber() {
        if (limit == 0) {
            return 1;
        }
        return offset / limit + 1;
    }

    public int getPageSize() {
        return limit;
    }

    public String getWhereCondition(String columnName) {
        return StringUtil.isNotEmpty(search) ? columnName + " LIKE '%" + search + "%'" : null;
    }

    public String getOrderBy() {
        if (StringUtil.isEmpty(sort) || StringUtil.isEmpty(order)) {
            return null;
        }
        return sort + " " + order.toUpperCase();
    }
}
