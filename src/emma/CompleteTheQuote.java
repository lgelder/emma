package emma;

import java.util.List;

public class CompleteTheQuote extends Activity implements ActivityInterface{
	private String sentence;
	private String answer;
	private List<Option> choices;
	
	public CompleteTheQuote(String person, String sentence, String answer, List<Option> choices){
		this.person = person;
		this.completed = false;
		this.instructions = "Enter the correct word/phrase to complete the quote: \n";
		this.sentence = sentence;
		this.answer = answer;
		this.choices = choices;
	}

	public String getPrintQuestion() {
		return getInstructions() + getSentence() + "\n" + getStringChoices();
	}

	public String getStringChoices() {
		String string = "";
		for (int i = 0; i < choices.size(); i++) {
			string += choices.get(i).stringOption() + "\n";
		}
		return string;
	}
	
	public String getSentence(){
		return this.sentence;
	}
	
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<Option> getChoices() {
		return choices;
	}

	public void setChoices(List<Option> choices) {
		this.choices = choices;
	}
	public Boolean checkAnswer(String a){
		a = a.toLowerCase();
		if (a.equals(getAnswer())){
			this.completed = true;
			return true;
		}
		return false;
		
	}
}
