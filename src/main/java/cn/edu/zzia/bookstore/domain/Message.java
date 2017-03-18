package cn.edu.zzia.bookstore.domain;

@SuppressWarnings("serial")
public class Message implements java.io.Serializable {

	private Integer code;
	private String msg;
	private Object data;

	public Message() {
	}

	public Message(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
