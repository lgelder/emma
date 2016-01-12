package emma;

//a non-playable character

public class Person{
	
	private String name;
	private TriviaQuestion question;
	
	public Person(String name, TriviaQuestion question){
		this.name = name;
		this.question = question;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TriviaQuestion getTriviaQuestion() {
		return question;
	}
	public void setTriviaQuestion(TriviaQuestion question) {
		this.question = question;
	}
	
	
	
}
