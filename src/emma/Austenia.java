package emma;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Austenia{
	
	public static List<Option> createTQOptions(List<String> list){
		List<Option> questionchoices = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			questionchoices.add( new Option((i+1), list.get(i)));
		}
		return questionchoices;
	}
	
	public static List<TriviaQuestion> createTQs(){
//		File myFile = new File("TriviaQuestions.txt");
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(myFile))))) {
//		    String line;
//		    while ((line = br.readLine()) != "\r") {
//		       // process the line.
//		    }
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		List<TriviaQuestion> listOfQuestions = new ArrayList<TriviaQuestion>();
		
		List<String> listOfOptions0 = new ArrayList<String>();
		listOfOptions0.add("Mr. Perry");
		listOfOptions0.add("Mr. Elton");
		listOfOptions0.add("Mr. Knightley");

		List<Option> listOfOptions1 = createTQOptions(listOfOptions0);
		TriviaQuestion question1 = new TriviaQuestion("Mr. Woodhouse's Question", 
			 "What is the name of my doctor?", 
				"Mr. Perry", listOfOptions1);
		listOfQuestions.add(question1);

		List<String> listOfOptions = new ArrayList<String>();
		listOfOptions.add("Elizabeth");
		listOfOptions.add("Augusta");
		listOfOptions.add("Jane");
		listOfOptions.add("Georgiana");
		
		List<Option> listOfOptions2 = createTQOptions(listOfOptions);
		TriviaQuestion question2 = new TriviaQuestion("Mrs. Elton Question", 
				"What is my first name?", 
				"Augusta", listOfOptions2);
		listOfQuestions.add(question2);		
		
		return listOfQuestions;
	}
	
	public static Locale setUp(){
		List<TriviaQuestion> listOfQuestions = Austenia.createTQs();
		
		Person mrWoodhouse = new Person("Mr. Woodhouse", listOfQuestions.get(0));
		
		Person mrsElton = new Person("Mrs. Elton", listOfQuestions.get(1));
		
		Locale hartfield = new Locale("Hartfield");
		hartfield.addPerson(mrWoodhouse);
		hartfield.addPerson(mrsElton);
		return hartfield;
	}
	
	public static void runCity(Locale l){
		for (int i=0; i < 2; i++){
			System.out.println("Hello, my name is " + l.getPeople().get(i).getName() + ".\n" + l.getPeople().get(i).getTriviaQuestion().printQuestion());
			boolean b = checkAnswer(l.getPeople().get(i).getTriviaQuestion());
			interpretAnswer(b);
		}
	}
	
	public static void main(String[] a){
		
		String welcome = "Welcome to Austenia. Select an estate number to get started: \n1. Hartfield";
		String thanksForPlaying = "Thank you for visiting Austenia. We hope you come back soon.";
		System.out.println(welcome);
		Scanner readIn = new Scanner(System.in);
		String selection = readIn.nextLine();
		if (selection == "1"){
			Locale hartfield = setUp();
			runCity(hartfield);
		}
		Locale hartfield = setUp();
		runCity(hartfield);
		System.out.println(thanksForPlaying);
		
	}
	public static boolean checkAnswer(TriviaQuestion tq){
		Scanner readIn = new Scanner(System.in);
	    String userChoice = readIn.nextLine();
	    int userString = Integer.parseInt(userChoice);
	    System.out.println("You chose number " + userChoice + ", " + 
	    		tq.getChoices().get(userString-1).getText() + ".");
	    
	    if (tq.getAnswer() == tq.getChoices().get(userString-1).getText()){
	    	return true;
	    }
	    return false;
	    
	}
		public static void interpretAnswer(boolean b){
			if (b == true){
				System.out.println("Congratulations! You are correct!\n");
			}else{
				System.out.println("Sorry, that's incorrect.\n");
			}
			
		}
}
