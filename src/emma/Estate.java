package emma;

import java.util.ArrayList;
import java.util.List;

//a house or estate

public class Estate implements Place {
	private String name;
	private Place city;
	private Boolean completed;
	private List<Place> people;
	
	public Estate(String name, Boolean completed){
		this.name = name;
		this.completed = completed;
		people = new ArrayList<Place>();
	}
	
	public void addInsidePlace(Place p){
		people.add(p);
	}
	
	public List<Place> getInsidePlaces(){
		return people;
	}
	
	public String getUncompletedPrintPlaces(){
		String people = "";
		for (Place p : this.people){
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

	public Place getContainerPlace() {
		return city;
	}

	public void setContainerPlace(Place place) {
		this.city = place;
	}
	
	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

}
