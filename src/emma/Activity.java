package emma;

public abstract class Activity implements ActivityInterface{
//	protected String person;
	protected Place person;
	protected String instructions;
	protected Boolean completed;
//	
//	public Activity(Person person, Boolean completed){
//		this.person = person;
//		this.completed = completed;
//	}
//	
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
//	public String getPerson() {
//		return person;
//	}
//	public void setPerson(String person) {
//		this.person = person;
//	}
	public Place getPerson() {
		return person;
	}
	public void setPerson(Place person) {
		this.person = person;
	}
	
}
