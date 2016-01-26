package emma;

import java.util.ArrayList;
import java.util.List;

public class City implements Place{
	private String name;
	private Boolean completed;
	private List<Place> estates;
	
	public City(String name, Boolean completed){
		this.name = name;
		this.completed = completed;
		this.estates = new ArrayList<Place>();
	}
	
	public void addInsidePlace(Place p){
		estates.add(p);
	}
	
	public List<Place> getInsidePlaces(){
		return estates;
	}
	
	public String getUncompletedPrintPlaces(){
		String estates = "";
		for (Place e : this.estates){
			if (!e.getCompleted()){
				estates += "\n" + e.getName();
			}
		}
		estates += "\n";
		return estates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	@Override
	public Place getContainerPlace() {
		return null;
	}

	@Override
	public void setContainerPlace(Place place) {
		System.out.println("city doesn't have a container place beside the country");
	}

}

