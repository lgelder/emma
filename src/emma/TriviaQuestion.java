package emma;


public class TriviaQuestion {
	private String title;
	private String description;
	private Boolean completed;
	private String question;
	private String answer;
	private String[] choices;
	
	public TriviaQuestion(String title, String description, String question, String answer, String[] choices){
		this.title = title;
		this.description = description;
		this.completed = false;
		this.question = question;
		this.answer = answer;
		this.choices = choices;
	}
	
	public String printQuestion(){
		String printOut = "";
		printOut = getTitle()+ "\n" + getDescription() + "\n" +  getQuestion() + "\nEnter the number (1-3) of one of these choices: \n" + getStringChoices();
		
		
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
		for (int i = 1; i < 4; i++) {
			string += i + ". " + choices[i-1] + "\n";
		}
		return string;
	}
	
	public String[] getChoices(){
		return choices;
	}

	public void setChoices(String[] choices) {
		this.choices = choices;
	}
//	public Option[] getChoices(){
//		return choices;
//	}
//
//	public void setChoices(Option[] choices) {
//		this.choices = choices;
//	}

}
