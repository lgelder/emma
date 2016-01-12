package emma;

import java.util.ArrayList;

//a house or estate

public class Locale {
	private String name;
	private ArrayList<Person> people;
	
	public Locale(String name){
		this.name = name;
	}
	
	public void addPerson(Person p){
		people.add(p);
	}
	
	public ArrayList<Person> getPeople(){
		return people;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
