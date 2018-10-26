package springmvc.mvctest;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Person {
	@Expose
	private String name;
	@Expose
	private int age;
	@Expose
	private boolean isChild;
//	@Expose
	private Date birth;
	@Expose
	private String hobby;
	
	@Expose
	private List<Phone> phones;
	
	
	
	
	
	
	
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public boolean isChild() {
		return isChild;
	}
	public void setChild(boolean isChild) {
		this.isChild = isChild;
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", isChild=" + isChild
				+ ", birth=" + birth + ", hobby=" + hobby + ", phones="
				+ phones + "]";
	}

	
}
