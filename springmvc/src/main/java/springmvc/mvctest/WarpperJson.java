package springmvc.mvctest;

import java.util.List;

import com.google.gson.annotations.Expose;

public class WarpperJson {
	@Expose
	private List<Person> persons;

	
	public WarpperJson(List<Person> persons) {
		super();
		this.persons = persons;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	
}
