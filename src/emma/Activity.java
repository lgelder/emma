package emma;

public abstract class Activity implements ActivityInterface{
//	protected String person;
	protected Person person;
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
	public void setDescription(String instructions) {
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
