package cn.edu.zzia.bookstore.domain;

@SuppressWarnings("serial")
public class CollectId implements java.io.Serializable {

	private String userId;
	private String bookId;

	public CollectId() {
	}

	public CollectId(String userId, String bookId) {
		super();
		this.userId = userId;
		this.bookId = bookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

}
