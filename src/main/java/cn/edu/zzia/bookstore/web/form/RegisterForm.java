package cn.edu.zzia.bookstore.web.form;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {
	
	private String id;
	private String username;
	private String password;
	private String password2;
	private String cellphone;
	private String address;
	private String email;
	private String nickname;
	private String birthday;
	private  Map<String,String> errors = new HashMap();
	private String checkcode;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCheckcode() {
		return checkcode;
	}
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//用户名不能为空，并且要是3-8位字母
	//密码不能为空，并且是3-8位数字
	//确认密码不能为空，并且要和一次一致
	//电子邮箱不能为空，并且要是一个格式合法的邮箱
	//生日可以为空，不为空时，必须要是一个日期
	//昵称不能为空，并且要是汉字
	//验证码不能为空
	public boolean validate(){
		boolean isOK = true;
		if(this.username==null || this.username.trim().equals("") ){
			isOK = false;
			errors.put("username", "用户名不能为空！！");
		}else{
			if(!this.username.matches("[a-zA-Z]{3,8}")){
				isOK = false;
				errors.put("username", "用户名必须是3-8位的字母！！");
			}
		}
		if(this.password==null || this.password.trim().equals("")){
			isOK = false;
			errors.put("password", "密码不能为空！！");
		}else{
			if(!this.password.matches("\\d{3,8}")){
				isOK = false;
				errors.put("password", "密码必须是3-8位的数字！！");
			}
		}
		
		//private String password2; 两次密码要一致
		if(this.password2!=null){
			if(!this.password2.equals(this.password)){
				isOK = false;
				errors.put("password2", "两次密码不一致！！");
			}
		}
		
		//private String email;   邮箱不能为空，不为空要是一个合法的邮箱
		// flx_itcast@sina.com.cn
		if(this.email==null || this.email.trim().equals("")){
			isOK = false;
			errors.put("email", "邮箱不能为空！！");
		}else{
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOK = false;
				errors.put("email", "邮箱不是一个合法邮箱！！");
			}
		}		
		
		//private String birthday;  可以为空，不为空时，要是一个合法的日期
		if(this.birthday!=null && this.birthday.trim().equals("")){
			try{
				DateLocaleConverter conver = new DateLocaleConverter();
				conver.convert(this.birthday,"yyyy-MM-dd");
			}catch (Exception e) {
				isOK = false;
				errors.put("birthday", "日期格式不正确！！");
			}
		}
		
		if(this.nickname==null || this.nickname.trim().equals("") ){
			isOK = false;
			errors.put("nickname", "昵称不能为空！！");
		}else{
			if(!this.nickname.matches("^[\u4e00-\u9fa5]+$")){
				isOK = false;
				errors.put("nickname", "昵称必须是汉字！！");
			}
		}
		if(this.address==null || this.address.trim().equals("") ){
			isOK = false;
			errors.put("address", "地址不能为空！！");
		}else{
			if(!this.address.matches("^[\u4e00-\u9fa5]+$")){
				isOK = false;
				errors.put("address", "地址必须是汉字！！");
			}
		}
		if(this.cellphone==null || this.cellphone.trim().equals("")){
			isOK = false;
			errors.put("cellphone", "联系电话不能为空！！");
		}else{
			if(!this.cellphone.matches("\\d{11}")){
				isOK = false;
				errors.put("cellphone", "联系电话必须是11位的数字！！");
			}
		}
		if(this.checkcode==null || this.checkcode.trim().equals("")){
			isOK=false;
			errors.put("checkcode", "验证码不能为空");
		}
		return isOK;
	}

}
