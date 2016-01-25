package emma;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Country{
	private List<City> cl;
	private Boolean completed;
	private int correct;
	private HashMap<String, Integer> scores;
	private String userName;
	protected State state;
	protected State inGame;
	protected State inCity;
	protected State inEstate;
	protected State inPerson;
	protected State inActivity;
	protected State gameOver;
	protected State saving;
	
	// Constructor. Maybe add another activity type and file later
	public Country(String cityFile, String estateFile, String personFile, String activityFile1, 
			String activityFile2, String activityFile3, String scoreFile){
		System.out.println("Setting up the game.");
		System.out.print("Creating 'States'...");
//		this.inGame = new InCountryState(this);
//		this.inCity = new InCityState(this);
//		this.inEstate = new InEstateState(this);
//		this.inPerson = new InPersonState(this);
//		this.inActivity = new InActivityState(this);
		this.gameOver = new GameOverState(this);
//		this.saving = new SavingState(this);
//		this.setState(inGame);
		System.out.print("Created 'States.' \nCreating Cities...");
		cl = createCities(cityFile);
		System.out.print("Created Cities. \nCreating Estates...");
		createEstates(estateFile);
		System.out.print("Created Estates. \nCreating People...");
		createPeople(personFile);
		System.out.print("Created People. \nCreating Activities...");
		createActivities(activityFile1, activityFile2, activityFile3);
		System.out.print("Created Activities. \nImporting scores...");
		setScores(createHighScores(scoreFile));
		System.out.print("Scores Imported.\n");
		System.out.println("Setup complete. \n\n");
		this.completed = false;
		
	}
	
	public static boolean isWhitespace(String str) {
	    if (str == null) {
	        return false;
	    }
	    int sz = str.length();
	    for (int i = 0; i < sz; i++) {
	        if ((Character.isWhitespace(str.charAt(i)) == false)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public List<City> createCities(String file){
		List<City> cityList = new ArrayList<City>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line  = reader.readLine();
			while (line != null){
				line = reader.readLine();
				while(!isWhitespace(line) && line != null){
	        		String name = line;
	        		City c = new City(name, false);
	        		cityList.add(c);
	        		line = reader.readLine();
				}
			}
			reader.close();
		} catch (IOException ex){
			ex.printStackTrace();
		}
		
		return cityList;
	}
	
	public void createEstates(String file){
		List<Estate> listOfEstates = new ArrayList<Estate>();
		try {
	        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
	        String line = null;
	        line = bufferedReader.readLine();
	        while(line != null) {
	        	line = bufferedReader.readLine();
	        	while(!isWhitespace(line) && line != null){
	        		String name = line;
	        		String cityName = bufferedReader.readLine();
	        		City city = this.findCity(cityName);
	        		Estate e = new Estate(name, false);
	        		e.setCity(city);
	        		listOfEstates.add(e);
	        		line = bufferedReader.readLine();
	        	}
	        }   
	        System.out.print("created estates...");
	        bufferedReader.close(); }

        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                file + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
            // Or we could just do this: 
//	             ex.printStackTrace();
        }
		for (City c : this.cl){
			for (Estate e : listOfEstates){
				if (c == e.getCity()){
					c.addEstate(e);
				}
			}
			System.out.print("added estates to cities...");
		}
	}
	
	public void createPeople(String file){
		List<Person> listOfPeople = new ArrayList<Person>();
		try {
	        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
	        String line = null;
	        line = bufferedReader.readLine();
	        while(line != null) {
	        	line = bufferedReader.readLine();
	        	while(!isWhitespace(line) && line != null){
	        		String name = line;
	        		String estateName = bufferedReader.readLine();
	        		Estate estate = findEstate(estateName);
	        		Person p = new Person(name, false);
	        		p.setEstate(estate);
	        		listOfPeople.add(p);
	        		line = bufferedReader.readLine();
	        	}
	        }   
	        System.out.print("created people...");
	        bufferedReader.close(); }

        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                file + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
            // Or we could just do this: 
//             ex.printStackTrace();
        }
		for (City c : cl){
			for (Estate e : c.getEstates()){
				for (Person p : listOfPeople){
					if (p.getEstate() == e){
						e.addPerson(p);
					}
				}
			}
		}
		System.out.print("added people to estates...");
	}
	
	public void createActivities(String tqFile, String ctqFile, String usFile){
		List<Activity> listOfActivities = new ArrayList<Activity>();
		try {
	        BufferedReader bufferedReader = new BufferedReader(new FileReader(tqFile));
			// Read TriviaQuestions
            String line = bufferedReader.readLine();
            while(line != null) {
            	line = bufferedReader.readLine();
            	while(!isWhitespace(line) && line != null){
            		String personName = line;
            		String question = bufferedReader.readLine();
            		String answer = bufferedReader.readLine();
            		List<String> choices = new ArrayList<String>();
            		String choice = bufferedReader.readLine();
            		while(!isWhitespace(choice) && choice != null){
                		choices.add(choice);
                		choice = bufferedReader.readLine();
            		}
            		line = choice;
            		List<Option> lo = createOptions(choices);
            		Person person = findPerson(personName);
            		Activity a = new TriviaQuestion(person, question, answer, lo);
            		listOfActivities.add(a);
            	}
            }   
    		System.out.print("added trivia questions...");
            bufferedReader.close();   
            
            // Read CompleteTheQuotes
	        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(ctqFile));
            String line2 = bufferedReader2.readLine();
            while(line2 != null) {
                line2 = bufferedReader2.readLine();
            	while(!isWhitespace(line2) && line2 != null){
            		String personName = line2;
            		String question = bufferedReader2.readLine();
            		String answer = bufferedReader2.readLine();
            		List<String> choices = new ArrayList<String>();
            		String choice = bufferedReader2.readLine();
            		while(!isWhitespace(choice) && choice != null){
                		choices.add(choice);
                		choice = bufferedReader2.readLine();
            		}
            		line2 = choice;
            		List<Option> lo = createOptions(choices);
            		Person person = findPerson(personName);
            		Activity a = new CompleteTheQuote(person, question, answer, lo);
            		listOfActivities.add(a);
            	}
            }
    		System.out.print("added complete the quotes...");
            bufferedReader2.close(); 

            // Read Unscrambles
	        BufferedReader bufferedReader3 = new BufferedReader(new FileReader(usFile));
            String line3 = null;
            line3 = bufferedReader3.readLine();
            while(line3 != null) {
            	line3 = bufferedReader3.readLine();
            	while(!isWhitespace(line3) && line3 != null){
            		String personName = line3;
            		String phrase = bufferedReader3.readLine();
            		String scrambled = bufferedReader3.readLine();
            		Person person = findPerson(personName);
            		Activity a = new Unscramble(person, phrase, scrambled);
            		listOfActivities.add(a);
            		line3 = bufferedReader3.readLine();
            	}
            }   
    		System.out.print("added unscrambles...");
            bufferedReader3.close(); 
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file");                  
            // Or we could just do this: 
//             ex.printStackTrace();
        }
		// Test that activities were created correctly
//		for (int i = 0; i < listOfActivities.size(); i++){
//			System.out.println(listOfActivities.get(i).getPrintQuestion());
//		}
		for (City c : cl){
			for (Estate e : c.getEstates()){
				for (Person p : e.getPeople()){
					for (Activity a : listOfActivities){
						if (a.getPerson() == p){
							p.addActivity(a);
						}
					}
				}
			}
		}
		System.out.print("added activities to people...");
	}
	
	public static List<Option> createOptions(List<String> list){
		List<Option> questionchoices = new ArrayList<Option>();
		for (int i = 0; i < list.size(); i++) {
			questionchoices.add( new Option((i+1), list.get(i)));
		}
		return questionchoices;
	}

	public static HashMap<String, Integer> createHighScores(String scoreFile){
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		try{
			FileReader fileReader = new FileReader(scoreFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			line = bufferedReader.readLine();
			while (line != null){
				String name = line;
				String strScore = bufferedReader.readLine();
				int score = Integer.parseInt(strScore);
				scores.put(name,  score);
//				String[] items = line.split("\\s+");
//				String name = items[0];
//				int score = Integer.parseInt(items[1]);
//				scores.put(name, score);
				line = bufferedReader.readLine();

			}
			bufferedReader.close();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return scores;
	}
	
	public City userInputCity(Scanner read){
		String selection = read.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase(); //found this function on StackOverflow: 
		City city = findCity(selection);		//http://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
		return city;
	}
	
	public Estate userInputEstate(Scanner read, City city){
		String selection = read.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase();
		Estate estate = findEstate(selection);
		return estate;
	}
	
	public Person userInputPerson(Scanner read, Estate estate){
		String selection = read.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase();
		Person person = findPerson(selection);
		return person;
	}
	
	public void run2(){
		Scanner read = new Scanner(System.in);
		String selection = "";
		while (!getCompleted() && !selection.equals("exit")){
			System.out.println("\nPlease select a city to which to travel from the following list:" + getUncompletedPrintCities());
			City city = userInputCity(read);
			if (city.getName().equals("back") || (city.getName().equals("exit"))){
				break;
			}
		    while (!city.getName().equals("null") && !city.getCompleted() && !selection.equals("exit")){
				System.out.println("\nWelcome to " +city.getName() + "! Please select an estate to visit from the \nfollowing list:" + city.getUncompletedPrintEstates());
				Estate estate = userInputEstate(read, city);
				if (estate.getName().equals("back")){
					break;
				}
				while (!estate.getName().equals("null") && !estate.getCompleted() && !selection.equals("exit")){
					System.out.println("\nWelcome to " + estate.getName() + "! Please select a person with whom you would like \nto converse "
							+ "from the following list of people currently at " + estate.getName() + estate.getUncompletedPrintPeople());
					Person person = userInputPerson(read, estate);
					if (person.getName().equals("back")){
						break;
					}
					while (!person.getName().equals("null") && !person.getCompleted() && !selection.equals("exit")){
						for (Activity a: person.getActivities()){
							if (!a.getCompleted()){
								System.out.println(a.getPrintQuestion());

							}
							selection = read.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase();
							if (selection.equals("back")){
								break;
							}
							Boolean answer = a.checkAnswer(selection);
							interpretAnswer(answer);
							if (answer){
								this.correct++;
							}
						}
						int counter = 0;
						for (Activity a : person.getActivities()){
							if (a.getCompleted() == true){
								counter++;
							}
						}
						if (counter == person.getActivities().size()){
							person.setCompleted(true);
							System.out.println("Congratulations! \nYou have completed all of the activities " 
							+ person.getName() + " asked of you!\n");
						}
					}
					int counter = 0;
					for (Person p : estate.getPeople()){
						if (p.getCompleted() == true){
							counter++;
						}
					}
					if (counter == estate.getPeople().size()){
						estate.setCompleted(true);
						System.out.println("Congratulations! \nYou have completed all of the activities at " 
								+ estate.getName() + "!\n");
					}
				}
				int counter = 0;
				for (Estate e : city.getEstates()){
					if (e.getCompleted()){
						counter++;
					}
				}
				if (counter == city.getEstates().size()){
					city.setCompleted(true);
					System.out.println("Congratulations! \nYou have completed all of the activities in " + city.getName() + "!\n");

				}
			}
		    int counter = 0;
		    for (City c: cl){
		    	if (c.getCompleted()){
		    		counter++;
		    	}
		    }
		    if (counter == cl.size()){
		    	setCompleted(true);
		    	System.out.println("Congratulations! \nYou have completed all of the activities in the entire game!");
		    	break;
		    }
		}		
		System.out.println("You completed " + this.correct + " actitivies!\nWould you like to save your score?");
		String keep = read.nextLine().toLowerCase();
		saveScore(read, keep);
		read.close();
	}
	
	public void run(Scanner read){
		this.state = new InCountryState(this);
		String userInput = null;
		while (this.getState() != gameOver){
			System.out.println(this.state.getInstructions());
			userInput = read.nextLine();
			if (userInput.equals("back")){
				this.state.entersBack();
			} else if (userInput.equals("exit")){
				this.state.entersExit();
			} else {
				this.state.entersOther(userInput);
			}
		}
	}
	
	public void saveScore(Scanner read, String keep){
		if (keep.startsWith("y")){
			try (FileWriter writer = new FileWriter("C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\Scores.txt", true)) {
				writer.write(this.userName + "\n" + this.correct + "\n");
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public String getUncompletedPrintCities() {
		String cities = "";
		for (City c : cl){
			if (!c.getCompleted()){
				cities += "\n" + c.getName();
			}
		}
		cities += "\n";
		return cities;
	}
	
	public City findCity(String city){ //turn these into factories????
		for (City c : cl){
			if (c.getName().equals(city)){  
	        	return c;
	        }
		}
		return new City("null", true);
	}

	public Estate findEstate(String estate){
		for (City c : cl){
			for (Estate e : c.getEstates()){
				if (e.getName().equals(estate));
			}
		}
		return new Estate("null", true);
	}
	
	public Person findPerson(String person){
		for (City c : cl){
			for (Estate e : c.getEstates()){
				for (Person p : e.getPeople()){
					if (p.getEstate().equals(e)){
						return p;
					}
				}
			}
		}
		return new Person("null", true);
	}
	
	public static void main(String[] a){
		Country austen = new Country(
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\Cities.txt", 
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\Estates.txt", 
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\People.txt", 
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\TriviaQuestions.txt", 
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\CompleteTheQuote.txt", 
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\Unscramble.txt",
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\Scores.txt");
			
		String welcome = "Welcome to 18th-century England!. Here you can visit cities and estates \n"
				+ "from Jane Austen's novels and complete activities given to you by various \n"
				+ "characters.  You can enter your choices and answers by typing them, and \n"
				+ "can type 'back' to go up a level (leave an estate, etc) at any time. (Leaving \n"
				+ "the country takes you out of the game.) We hope you enjoy your time here!";
		System.out.println(welcome);
		
		String getName = "Please enter your name: ";
		System.out.println(getName);
		
		Scanner read = new Scanner(System.in);
		austen.userName = read.nextLine();
		
		System.out.println("Here are the saved scores of all players. Try to beat them!");
		austen.printHighScores();
		
		austen.run(read);
		read.close();

		String thanksForPlaying = "Thank you for visiting us! We hope you come back soon.";
		System.out.println(thanksForPlaying);
		
	}

	private void printHighScores() {
		for ( HashMap.Entry<String, Integer> entry : scores.entrySet()) {
		    String name = entry.getKey();
		    int score = entry.getValue();
		    System.out.println(name + "\t" + score);
		}		
	}
	public static void interpretAnswer(boolean b){
		if (b == true){
			System.out.println("Congratulations! You are correct!\n");
		}else{
			System.out.println("Sorry, that's incorrect.\n");
		}
	}
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public HashMap<String, Integer> getScores() {
		return scores;
	}
	public void setScores(HashMap<String, Integer> scores) {
		this.scores = scores;
	}
	public void setState(State state) {
		this.state = state;
		
	}
	public State getState() {
		return this.state;
		
	}
}
