package springmvc.mvctest;

import com.google.gson.annotations.Expose;

public class Phone {
	@Expose
	private String type;
	@Expose
	private String size;
	
	public Phone(String type, String size) {
		super();
		this.type = type;
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Phone [type=" + type + ", size=" + size + "]";
	}
	
	
	
}
