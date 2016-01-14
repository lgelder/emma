package emma;

import java.util.List;

public class CompleteTheQuote extends Activity implements ActivityInterface{
	private String title;
	private String sentence;
	private String answer;
	private List<Option> choices;
	
	public CompleteTheQuote(String title, String sentence, String answer, List<Option> choices){
		this.setTitle(title);
		this.setSentence(sentence);
		this.setAnswer(answer);
		this.setChoices(choices);
	}

	public String getPrintQuestion() {
		return sentence;
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
	public Boolean checkAnswer(String answer){
		if (answer == this.answer){
			return true;
		}
		return false;
		
	}
}
