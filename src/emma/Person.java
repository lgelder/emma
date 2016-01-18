package emma;

import java.util.*;

//a non-playable character

public class Person implements PersonInterface{
	
	private String name;
	private String estate;
	private List<Activity> activities;
	
	public Person(String name, String estate){
		this.name = name;
		this.setEstate(estate);
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
	
	
	
}
