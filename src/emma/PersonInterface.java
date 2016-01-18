package emma;



import java.util.List;

public interface PersonInterface {
	public String getName();
	public Activity getActivity(int i);
	public void addActivity(Activity activity);
	public List<Activity> getActivities();
}
