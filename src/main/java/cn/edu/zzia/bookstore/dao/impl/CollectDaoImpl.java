package cn.edu.zzia.bookstore.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.zzia.bookstore.dao.ICollectDao;
import cn.edu.zzia.bookstore.domain.Collect;

@Repository(ICollectDao.SERVICE_NAME)
public class CollectDaoImpl extends CommonDaoImpl<Collect> implements ICollectDao {

}
