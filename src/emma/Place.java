package emma;

import java.util.List;

public interface Place {
	public void setName(String name);
	public String getName();
	public void setCompleted(Boolean completed);
	public Boolean getCompleted();
	public void addInsidePlace(Place place);
	public List<Place> getInsidePlaces();
	public String getUncompletedPrintPlaces();
	public Place getContainerPlace();
	public void setContainerPlace(Place place);
}
