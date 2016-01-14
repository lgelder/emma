package emma;

import java.util.ArrayList;
import java.util.List;

public class City {
	private String name;
	private List<Estate> estates;
	
	public City(String name){
		this.name = name;
		estates = new ArrayList<Estate>();
	}
	
	public void addEstate(Estate e){
		estates.add(e);
	}
	
	public List<Estate> getEstates(){
		return estates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

