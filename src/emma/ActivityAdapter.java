package emma;

import java.util.List;

public class ActivityAdapter implements Place {
	private Activity activity;
	
	public ActivityAdapter(Activity a){
		this.activity = a;
	}
	
	@Override
	public void setName(String name) {
		activity.setInstructions(name);
	}

	@Override
	public String getName() {
		return activity.getInstructions();
	}

	@Override
	public void setCompleted(Boolean completed) {
		activity.setCompleted(completed);
	}

	@Override
	public Boolean getCompleted() {
		return activity.getCompleted();
	}

	@Override
	public void addInsidePlace(Place place) {
		System.out.println("Can't add things to activities!");
	}

	@Override
	public List<Place> getInsidePlaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUncompletedPrintPlaces() {
		return activity.getPrintQuestion();
	}

	@Override
	public Place getContainerPlace() {
		return activity.getPerson();
	}

	@Override
	public void setContainerPlace(Place place) {
		activity.setPerson(place);
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
