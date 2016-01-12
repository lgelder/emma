package emma;


public class CompleteTheQuote extends Activity{
	private String sentence;
	private String answer;
	private String[] choices;
	
	private CompleteTheQuote(String sentence, String answer, String[] choices){
		this.sentence = sentence;
		this.answer = answer;
		this.choices = choices;
	}
}
