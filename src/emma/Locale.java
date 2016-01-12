package emma;

import java.util.ArrayList;
import java.util.List;

//a house or estate

public class Locale {
	private String name;
	private List<Person> people;
	
	public Locale(String name){
		this.name = name;
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

}
