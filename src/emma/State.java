package emma;

public interface State {
	public void entersBack();
	public void entersExit();
	public void entersOther(String text);
	public void setPlace(Place place);
	public Place getPlace();
	public void setInstructions(String text);
	public String getInstructions();
	
}
