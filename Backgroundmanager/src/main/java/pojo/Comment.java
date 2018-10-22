package pojo;

import java.io.Serializable;

public class Comment implements Serializable {
	private int total;
	private int id;
	public int getCount() {
		return total;
	}
	public void setCount(int count) {
		this.total = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
