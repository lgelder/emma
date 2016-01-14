package emma;

public abstract class Activity implements ActivityInterface{
	protected String title;
	protected String instructions;
	protected Boolean completed;
	
	public String getInstructions() {
		return instructions;
	}
	public void setDescription(String instructions) {
		this.instructions = instructions;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
