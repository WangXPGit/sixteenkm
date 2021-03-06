/** 
 * DataAccessor.java Create on 2017-12-21
 */

package com.sixteenkm.api.jdbc.dao;

import java.util.List;
import java.util.Map;

import com.sixteenkm.api.jdbc.paging.Paging;

/**
 * 数据访问器接口
 * 
 * @project api-framework
 * @author WangXP
 * @since 1.1.1
 * @date 2017-12-21
 */
public interface DataAccessor {

	<T> T selectOne(String statementId);
	<T> T selectOne(String statementId, Object sqlParam);

	<T> List<T> selectList(String statementId);
	<T> List<T> selectList(String statementId, Object sqlParam);

	<K, V> Map<K, V> selectMap(String statementId, String mapKey);
	<K, V> Map<K, V> selectMap(String statementId, Object sqlParam, String mapKey);

	<T> Paging<T> selectPaging(String statementId, int pageNumber, int pageSize);
	<T> Paging<T> selectPaging(String statementId, Object sqlParam, int pageNumber, int pageSize);

	int insert(String statementId);
	int insert(String statementId, Object sqlParam);

	int update(String statementId);
	int update(String statementId, Object sqlParam);

	int delete(String statementId);
	int delete(String statementId, Object sqlParam);
}
