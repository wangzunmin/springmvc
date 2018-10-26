package springmvc.mvctest.rest.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
	private Integer bno;
	private String name;
	private String author;
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
