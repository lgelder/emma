package emma;

import java.util.List;

public class TriviaQuestion extends Activity implements ActivityInterface{
	private String question;
	private String answer;
	private List<Option> choices;
	
	public TriviaQuestion(String title, String question, String answer, List<Option> choices){
		this.title = title;
		this.completed = false;
		this.instructions = "Enter your answer in word format: \n";
		this.question = question;
		this.answer = answer;
		this.choices = choices;
	}
	public String getPrintQuestion(){
		String printOut = "";
		printOut = getQuestion() + "\n" + getInstructions() + getStringChoices();
		
		
		return printOut;
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
	public Boolean checkAnswer(String a){
		a = a.toLowerCase();
		if (a == getAnswer()){
			return true;
		}
		return false;
	}
}
