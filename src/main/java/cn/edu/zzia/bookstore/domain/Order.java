package cn.edu.zzia.bookstore.domain;
// Generated 2017-3-10 14:17:41 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Orders generated by hbm2java
 */
@SuppressWarnings("serial")
public class Order implements java.io.Serializable {

	private String id;
	private User user;
	private Date ordertime;
	private Double price;
	private Boolean state;
	private Boolean isDelete;
	private Set<Orderitem> orderitems = new HashSet<Orderitem>(0);

	public Order() {
	}

	public Order(String id, Date ordertime) {
		this.id = id;
		this.ordertime = ordertime;
	}

	public Order(String id, User user, Date ordertime, Double price, Boolean state, Set<Orderitem> orderitems) {
		this.id = id;
		this.user = user;
		this.ordertime = ordertime;
		this.price = price;
		this.state = state;
		this.orderitems = orderitems;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Set<Orderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}
}