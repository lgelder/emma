package emma;

import java.util.ArrayList;
import java.util.List;

//a house or estate

public class Estate {
	private String name;
//	private String city;
	private City city;
	private Boolean completed;
	private List<Person> people;
	
	public Estate(String name, City city, Boolean completed){
		this.name = name;
		this.city = city;
		this.completed = completed;
		people = new ArrayList<Person>();
	}
	
	public void addPerson(Person p){
		people.add(p);
	}
	
	public List<Person> getPeople(){
		return people;
	}
	
	public String getUncompletedPrintPeople(){
		String people = "";
		for (Person p : this.people){
			if (!p.getCompleted()){
				people += "\n" + p.getName();
			}
		}
		people += "\n";
		return people;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

}
