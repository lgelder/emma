package emma;

import java.util.List;

public class TriviaQuestion {
	private String title;
	private String description;
	private Boolean completed;
	private String question;
	private String answer;
	private List<Option> choices;
	
	public TriviaQuestion(String title, String description, String question, String answer, List<Option> choices){
		this.title = title;
		this.description = description;
		this.completed = false;
		this.question = question;
		this.answer = answer;
		this.choices = choices;
	}
	
	public String printQuestion(){
		String printOut = "";
		printOut = getTitle()+ "\n" + getDescription() + "\n" +  getQuestion() + "\nEnter a number (1-3): \n" + getStringChoices();
		
		
		return printOut;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		for (int i = 0; i < 3; i++) {
			string += choices.get(i).stringOption() + "\n";
		}
		return string;
	}
	
//	public String[] getChoices(){
//		return choices;
//	}
//
//	public void setChoices(String[] choices) {
//		this.choices = choices;
//	}
	
	public List<Option> getChoices(){
		return choices;
	}

	public void setChoices(List<Option> choices) {
		this.choices = choices;
	}

}
