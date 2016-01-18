package emma;

import java.util.ArrayList;
import java.util.List;

//a house or estate

public class Estate {
	private String name;
	private String city;
	private Boolean completed;
	private List<Person> people;
	
	public Estate(String name, String city){
		this.name = name;
		this.setCity(city);
		this.completed = false;
		people = new ArrayList<Person>();
	}
	
	public void addPerson(Person p){
		people.add(p);
	}
	
	public List<Person> getPeople(){
		return people;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

}
