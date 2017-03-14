package cn.edu.zzia.bookstore.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zzia.bookstore.dao.IPublisherDao;
import cn.edu.zzia.bookstore.domain.Publisher;
import cn.edu.zzia.bookstore.service.IPublisherService;
import cn.edu.zzia.bookstore.util.WebUtils;

@Service(IPublisherService.SERVICE_NAME)
@Transactional(readOnly = true)
public class PublisherServiceImpl implements IPublisherService {

	@Resource(name = IPublisherDao.SERVICE_NAME)
	private IPublisherDao publisherDao = null;

	@Override
	public List<Publisher> findAllPublisher() {

		LinkedHashMap<String, String> orderby = new LinkedHashMap<>();
		orderby.put("o.id", "asc");
		return publisherDao.findObjectsByConditionWithNoPage(orderby);
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
	public void addPublisher(Publisher publisher) {

		if (null != publisher && StringUtils.isNotBlank(publisher.getPublisherName())) {
			publisher.setId(WebUtils.makeID());
			publisherDao.save(publisher);
		}
	}

	@Override
	public Publisher findPublisherById(String publisherId) {
		if (StringUtils.isNotBlank(publisherId)) {
			return publisherDao.findObjectById(publisherId);
		}
		return null;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
	public void updatePublisher(Publisher publisher) {
		if (null != publisher && StringUtils.isNotBlank(publisher.getId())
				&& StringUtils.isNotBlank(publisher.getPublisherName())) {
			publisherDao.update(publisher);
		}
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
	public void deletePublisherById(String publisherId) {

		// String whereHql = " and o.publisher.id = ? ";
		// Object[] params = {publisherId};
		// List<Book> books = bookDao.findObjectsByConditionWithNoPage(whereHql,
		// params);
		// bookDao.deleteAllObjects(books);
		publisherDao.deleteByIds(publisherId);
	}
}
