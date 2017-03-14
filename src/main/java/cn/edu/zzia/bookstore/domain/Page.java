package cn.edu.zzia.bookstore.domain;

import java.util.List;

public class Page {

	private int startindex; // 记住用户想看的页数据从哪里开始取
	private int pagesize = 3; // 页面大小
	private int totalrecord; // 记住分页总记录数
	private int totalpage; // 记住总页数

	private List list; // 记住页面数据
	private int pagenum; // 记住当前页

	private int endPage;
	private int startPage;
	
	public Page(int pagenum){
		this.pagenum = pagenum;
	}
	
	// 用在servlet的业务层中
	public Page(int pagenum, int totalrecord) {
		this.pagenum = pagenum;
		this.totalrecord = totalrecord;
		// 算出总页数
		this.totalpage = (this.totalrecord + this.pagesize - 1) / this.pagesize;
		// 算出用户想看页的数据从数据库的那个地方开始取
		this.startindex = (this.pagenum - 1) * this.pagesize;
		if (this.pagesize <= 10) {
			this.startPage = 1;
			this.endPage = this.totalpage;
		} else {
			this.startPage = pagenum - 4;
			this.endPage = pagenum + 5;

			if (startPage < 1) {
				this.startPage = 1;
				this.endPage = 10;
			}
			if (this.endPage > this.pagesize) {
				this.endPage = this.totalpage;
				this.startPage = this.totalpage - 9;
			}
		}
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getTotalrecord() {
		return totalrecord;
	}

	// 在hibernate中有效
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
		
		// 算出总页数
		this.totalpage = (this.totalrecord + this.pagesize - 1) / this.pagesize;
		// 算出用户想看页的数据从数据库的那个地方开始取
		this.startindex = (this.pagenum - 1) * this.pagesize;
		if (this.pagesize <= 10) {
			this.startPage = 1;
			this.endPage = this.totalpage;
		} else {
			this.startPage = pagenum - 4;
			this.endPage = pagenum + 5;

			if (startPage < 1) {
				this.startPage = 1;
				this.endPage = 10;
			}
			if (this.endPage > this.pagesize) {
				this.endPage = this.totalpage;
				this.startPage = this.totalpage - 9;
			}
		}
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

}
