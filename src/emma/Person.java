package emma;

import java.util.*;

//a non-playable character

public class Person implements Place{
	private String name;
	private Place estate;
	private Boolean completed;
	private List<Place> activities;
	
	public Person(String name, Boolean completed){
		this.name = name;
		this.completed = completed;
		this.activities = new ArrayList<Place>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Place getActivity(int i) {
		return activities.get(i);
	}
	public void addInsidePlace(Place activity) {
		this.activities.add(activity);
	}

	public Place getContainerPlace() {
		return estate;
	}

	public void setContainerPlace(Place place) {
		this.estate = place;
	}
	
	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	public List<Place> getInsidePlaces(){
		return this.activities;
	}

	@Override
	public String getUncompletedPrintPlaces() {
		System.out.println("Shouldn't try to print all activities at once.");
		return null;
	}
	
}
