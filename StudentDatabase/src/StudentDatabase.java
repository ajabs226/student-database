import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDatabase {

	public static void main(String[] args) {
          
		Scanner scan = new Scanner(System.in);
        int studentSelection = 0;
        String infoSelection = null;
        String again = null;
        String hometownInfo = null;
        String foodInfo = null;
        boolean correctInput = true;

        String studentArr[] = {"Mrs Neugeboren", "Flo", "Lloyd Christmas", "Harry Dunne", "Mary Swanson", 
        		"Gas Man", "Billy from 4C", "Sea Bass", "Petey the Bird", "Nicholas Andre"};
        String hometownArr[] = {"Chinatown", "The Bronx", "Providence, RI", "Chicago, IL", 
        		"Aspen, CO", "Detroit, MI", "Cleveland, OH", "Orlando, FL", "Lincoln, Nebraska", "Compton"};
        String foodArr[] = {"Foot Long", "Soup du jour", "Big Gulps", "Hamburger", "Salmon", 
        		"Bacon Grilled Cheese", "Pizza", "Steak", "Crackers", "Salad"};  

        //Select student
        do {

        	System.out.println("Which student would you like to learn more about?  Enter a number 1-10");

        	for (int i = 0; i < studentArr.length; i++) {
        		System.out.println((i+1) + ". " + studentArr[i]);

              }
                  
        	try {
        		studentSelection = scan.nextInt();
                scan.nextLine();

                System.out.println("Student " + studentSelection + " is " + studentArr[studentSelection - 1]
                		+ ". What would you like to know about " + studentArr[studentSelection - 1] + "? Enter [hometown] or [favorite food]." );
                infoSelection = scan.nextLine();
                
                if(infoSelection.equalsIgnoreCase("Hometown")) {
                  	hometownInfo = hometownArr[studentSelection-1];
                    System.out.println(studentArr[studentSelection - 1] + " is from " + hometownInfo + ".\n");

                } else if(infoSelection.equalsIgnoreCase("Favorite Food")) {
                	foodInfo = foodArr[studentSelection-1];
                	System.out.println(studentArr[studentSelection - 1] + "'s favorite food is " + foodInfo + ".\n");

                } else if (!(infoSelection.equalsIgnoreCase("hometown") || !(infoSelection.equalsIgnoreCase("Favorite Food")))){
                	System.out.println("That data does not exist.  Please try again.  Enter [hometown] or [favorite food]");

                } else {
                	throw new Exception();
                }

        	} catch (ArrayIndexOutOfBoundsException e) {
        		System.out.println("That student does not exist.  Please try again.\n");

        	} catch (IllegalStateException e) {
        		System.out.println("Not valid.  Please try again.\n");

        	} catch (InputMismatchException e) {
         		scan.next();
        		System.out.println("Not a valid input.  Please try again.\n");

        	} catch (Exception e) {
        		System.out.println("That is not a valid input.  Please try again.\n");
        	}

        	System.out.println("Would you like to learn more about another student? (y/n)\n");
        	again = scan.next();

        	try {

        		if(again.equalsIgnoreCase("y")) {
        			System.out.println("Great!\n");

        		} else if (again.equalsIgnoreCase("n")) {
                   System.out.println("Thanks!");
                   break;

        		} else {
        			throw new Exception();
        		}

        	} catch (Exception e) {
        		correctInput = false;
        		System.out.println("Goodbye\n");
        	}

        } while(correctInput);

	}

	public static String studentHome(String hometown) {

		for(int i = 0; i < hometown.length(); i++) {
			i++;
		}

		return hometown;

	}

	public static String studentFood(String favFood) {

		for (int i = 0; i < favFood.length(); i++) {
			i++;
		}

		return favFood;

	}

}