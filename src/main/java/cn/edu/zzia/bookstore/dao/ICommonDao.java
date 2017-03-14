package cn.edu.zzia.bookstore.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import cn.edu.zzia.bookstore.domain.Page;

public interface ICommonDao<T> {
	/**
	 * 保存一个实体bean到数据库
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 更新数据库中的实体bean
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 根据id查找数据库中的某一个实体bean
	 * @param id
	 * @return
	 */
	T findObjectById(Serializable id);

	/**
	 * 根据id数组批量删粗数据库中的数据
	 * @param ids
	 */
	void deleteByIds(Serializable... ids);
	
	/**
	 * 根据集合批量删除数据库中的数据
	 * @param entities
	 */
	void deleteAllObjects(Collection<T> entities);

	/**
	 * 根据hql语句，和相应参数查询数据，并排序，不分页
	 * @param whereHql
	 * @param params
	 * @param orderby
	 * @return
	 */
	List<T> findObjectsByConditionWithNoPage(String whereHql, Object[] params, LinkedHashMap<String, String> orderby);

	List<T> findObjectsByConditionWithNoPage(String whereHql, Object[] params);

	List<T> findObjectsByConditionWithNoPage(LinkedHashMap<String, String> orderby);

	List<T> findObjectsByConditionWithNoPage();

	/**
	 * 分页查询数据库中的数据
	 * @param hqlWhere
	 * @param params
	 * @param orderby
	 * @param pageInfo
	 * @return
	 */
	List<T> findCollectionByConditionWithPage(String hqlWhere, final Object[] params,
			LinkedHashMap<String, String> orderby, final Page pageInfo);

}
