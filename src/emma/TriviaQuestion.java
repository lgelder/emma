package emma;

import java.util.List;

public class TriviaQuestion {
	private String title;
	private String instructions = "Enter a number (1-3): \n";
	private Boolean completed;
	private String question;
	private String answer;
	private List<Option> choices;
	
	public TriviaQuestion(String title, String question, String answer, List<Option> choices){
		this.title = title;
		this.completed = false;
		this.question = question;
		this.answer = answer;
		this.choices = choices;
	}
	
	public String printQuestion(){
		String printOut = "";
		printOut = getQuestion() + "\n" + getInstructions() + getStringChoices();
		
		
		return printOut;
	}
	
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getStringChoices() {
		String string = "";
		for (int i = 0; i < choices.size(); i++) {
			string += choices.get(i).stringOption() + "\n";
		}
		return string;
	}
	public List<Option> getChoices(){
		return choices;
	}
	public void setChoices(List<Option> choices) {
		this.choices = choices;
	}
}
