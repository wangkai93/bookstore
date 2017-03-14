package cn.edu.zzia.bookstore.service;

import java.util.List;

import cn.edu.zzia.bookstore.domain.Publisher;

public interface IPublisherService {

	public static final String SERVICE_NAME = "cn.edu.zzia.bookstore.service.impl.PublisherServiceImpl";

	/**
	 * 保存出版社信息
	 * @param publisher
	 */
	void addPublisher(Publisher publisher);

	/**
	 * 根据id查找出版社信息
	 * @param publisherId
	 * @return
	 */
	Publisher findPublisherById(String publisherId);

	/**
	 * 更新出版社信息
	 * @param publisher
	 */
	void updatePublisher(Publisher publisher);

	/**
	 * 查找所有的出版社
	 * @return
	 */
	List<Publisher> findAllPublisher();

	/**
	 * 根据id删除出版社信息
	 * @param publisherId
	 */
	void deletePublisherById(String publisherId);
}
