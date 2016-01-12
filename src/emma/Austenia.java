package emma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Austenia{
	
	public static List<Option> createTQOptions(String one, String two, String three){
		Option b = new Option(1, one);
		Option c = new Option(2, two);
		Option d = new Option(3, three);
		List<Option> questionchoices = new ArrayList();
		questionchoices.add(b);
		questionchoices.add(c);
		questionchoices.add(d);
		return questionchoices;
	}
	
	public static List<TriviaQuestion> createTQs(){
		List<TriviaQuestion> listOfQuestions = new ArrayList<TriviaQuestion>();
		
		List<Option> listOfOptions1 = createTQOptions("Mr. Perry", "Mr. Elton", "Mr. Knightley");
		TriviaQuestion question1 = new TriviaQuestion("Mr. Woodhouse's Question", 
				"Answer the multiple choice question.", "What is the name of Mr. Woodhouse's doctor?", 
				"Mr. Perry", listOfOptions1);
		listOfQuestions.add(question1);
		
		List<Option> listOfOptions2 = createTQOptions("Catherine", "Augusta", "Elizabeth");
		TriviaQuestion question2 = new TriviaQuestion("Mrs. Weston's Question", 
				"Answer the multiple choice question.", "What is Mrs. Elton's first name?", 
				"Augusta", listOfOptions2);
		listOfQuestions.add(question2);
		
		List<Option> listOfOptions3 = createTQOptions("Mr. Perry", "Mr. Elton", "Mr. Knightley");
		TriviaQuestion question3 = new TriviaQuestion("Mr. Woodhouse's Question", 
				"Answer the multiple choice question.", "What is the name of Mr. Woodhouse's doctor?", 
				"Mr. Perry", listOfOptions3);
		listOfQuestions.add(question3);
		
		
		return listOfQuestions;
	}
	
	
	
	public static void main(String[] a){
		
		List<TriviaQuestion> listOfQuestions = Austenia.createTQs();
				
		Person mrWoodhouse = new Person("Mr. Woodhouse", listOfQuestions.get(0));
		
		Person mrsWeston = new Person("Mrs. Weston", listOfQuestions.get(1));
		
		Locale hartfield = new Locale("Hartfield");
		hartfield.addPerson(mrWoodhouse);
		hartfield.addPerson(mrsWeston);
		System.out.println(hartfield.getPeople().get(0).getTriviaQuestion().printQuestion());
		
//		System.out.println(mrWoodhouse.getTriviaQuestion().printQuestion());
		
		
	    Scanner readIn = new Scanner(System.in);
	    String userChoice = readIn.nextLine();
	    int userString = Integer.parseInt(userChoice);
	    System.out.println("You chose number " + userChoice + ", " + 
	    		mrWoodhouse.getTriviaQuestion().getChoices().get(userString-1).getText() + ".");
	    
	    if (mrWoodhouse.getTriviaQuestion().getAnswer() == 
	    		mrWoodhouse.getTriviaQuestion().getChoices().get(userString-1).getText()){
	    	System.out.println("you are correct!\n");
	    }else{
	    	System.out.println("Oops, that's wrong.\n");
	    }
	    
		System.out.println(hartfield.getPeople().get(1).getTriviaQuestion().printQuestion());

//		System.out.println(mrsWeston.getTriviaQuestion().printQuestion());
		
		
	    userChoice = readIn.nextLine();
	    userString = Integer.parseInt(userChoice);
	    readIn.close();            
	    System.out.println("You chose number " + userChoice + ", " + 
	    		mrsWeston.getTriviaQuestion().getChoices().get(userString-1).getText() + ".");
	    
	    if (mrsWeston.getTriviaQuestion().getAnswer() == 
	    		mrsWeston.getTriviaQuestion().getChoices().get(userString-1).getText()){
	    	System.out.println("you are correct!");
	    }else{
	    	System.out.println("Oops, that's wrong.");
	    }
	    
//		System.out.println(mrWoodhouse.getTriviaQuestion().getTitle());
	}

}
