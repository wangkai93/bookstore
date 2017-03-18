package cn.edu.zzia.bookstore.domain;

import java.util.Date;

@SuppressWarnings("serial")
public class Collect implements java.io.Serializable {

	private CollectId id;

	private Date collectTime;

	public CollectId getId() {
		return id;
	}

	public void setId(CollectId id) {
		this.id = id;
	}

	public Date getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

}
