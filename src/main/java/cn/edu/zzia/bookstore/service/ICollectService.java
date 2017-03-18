package cn.edu.zzia.bookstore.service;

import java.util.List;

import cn.edu.zzia.bookstore.domain.Collect;
import cn.edu.zzia.bookstore.domain.Page;

public interface ICollectService {

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.service.impl.CollectServiceImpl";

	/**
	 * 保存用户收藏的书籍
	 * @param userId
	 * @param bookId
	 */
	void saveCollect(String userId, String bookId);

	/**
	 * 根据用户id查询该用户所有的收藏
	 * @param userId
	 * @param pagenum
	 * @return
	 */
	Page findAllCollectByUserId(String userId,String pagenum);

	/**
	 * 根据用户id和书籍id删除收藏
	 * @param userId
	 * @param bookId
	 */
	void deleteCollectByUserIdAndBookId(String userId, String bookId);

	/**
	 * 根据用户id查找该用户收藏的所有书籍
	 * @param userId
	 * @return
	 */
	List<Collect> selectCollectByUserId(String userId);
}
