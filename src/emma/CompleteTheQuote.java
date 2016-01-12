package emma;


public class CompleteTheQuote extends Activity{
	private String sentence;
	private String answer;
	private String[] choices;
	
	private CompleteTheQuote(String sentence, String answer, String[] choices){
		this.setSentence(sentence);
		this.setAnswer(answer);
		this.setChoices(choices);
	}

	public String getSentence() {
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

	public String[] getChoices() {
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}
}
