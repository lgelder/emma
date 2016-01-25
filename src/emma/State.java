package emma;

public interface State {
	public void entersBack();
	public void entersExit();
	public void entersOther(String text);
	public void setPlace(String text);
	public Object getPlace();
	
}
