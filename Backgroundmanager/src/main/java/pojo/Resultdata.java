package pojo;

import java.io.Serializable;
import java.util.List;

public class Resultdata implements Serializable{
	private boolean ok;
	private List<Article> list;
	private List<Categorye> listcategory;
	private List<User> listcomments;
	private int count;
	private boolean issearch;
	private String searchcontent;
	
	
	public String getSearchcontent() {
		return searchcontent;
	}
	public void setSearchcontent(String searchcontent) {
		this.searchcontent = searchcontent;
	}
	public boolean isIssearch() {
		return issearch;
	}
	public void setIssearch(boolean issearch) {
		this.issearch = issearch;
	}
	public List<User> getListcomments() {
		return listcomments;
	}
	public void setListcomments(List<User> listcomments) {
		this.listcomments = listcomments;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Categorye> getListcategory() {
		return listcategory;
	}
	public void setListcategory(List<Categorye> listcategory) {
		this.listcategory = listcategory;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public List<Article> getList() {
		return list;
	}
	public void setList(List<Article> list) {
		this.list = list;
	}
	

}
