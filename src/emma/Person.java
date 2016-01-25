package emma;

import java.util.*;

//a non-playable character

public class Person {
	private String name;
	private String estate;
	private Boolean completed;
	private List<Activity> activities;
	
	public Person(String name, String estate, Boolean completed){
		this.name = name;
		this.estate = estate;
		this.completed = completed;
		this.activities = new ArrayList<Activity>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Activity getActivity(int i) {
		return activities.get(i);
	}
	public void addActivity(Activity activity) {
		this.activities.add(activity);
	}

	public String getEstate() {
		return estate;
	}

	public void setEstate(String estate) {
		this.estate = estate;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
	public List<Activity> getActivities(){
		return this.activities;
	}
	
}
