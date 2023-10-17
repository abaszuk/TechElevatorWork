package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		House blueHouse1 = new House();
		blueHouse1.setColor(House.BLUE);
		System.out.println("House color is " + blueHouse1.getColor());


		House secondReferenceToBlueHouse1 = blueHouse1;


		House redHouse1 = new House();
		redHouse1.setColor("Red");

		House blueHouse2 = new House();
		blueHouse2.setColor("Blue");


				//static example




		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */

		String name = "Tech Elevator";


		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		//You can check if a string begins or ends with any other string of letters

		boolean startsWithTech = name.startsWith("Tech");
		System.out.println("Starts with Tech: " + startsWithTech);

		boolean startsWithLowerTech = name.startsWith("tech");
		System.out.println("Starts with tech: " + startsWithLowerTech);

		boolean endsWithElevator = name.endsWith("Elevator");
		System.out.println("Ends with Elevator: " + endsWithElevator);

		boolean endsWithOr = name.endsWith("or");
		System.out.println("Ends with or: " + endsWithOr);

		//We can force lower or upper case
		System.out.println("Uppercase: " + name.toUpperCase());
		System.out.println("Lowercase: " + name.toLowerCase());

		//We can use those methods to make things case insensitive
		boolean endsWithElevator2 = name.toLowerCase().endsWith("elevator");
		System.out.println("Ends With Elevator Case Insensitive: " + endsWithElevator2);


		//If we want the value at a certain index
		System.out.println("Character at index 7: " + name.charAt(7));

		//If we want to find where "elevator" starts
		System.out.println("Elevator starts at index " + name.indexOf("Elevator"));
		System.out.println("What is the first e that shows up: " + name.indexOf("e"));

		System.out.println("Where is the last e that shows up: " + name.lastIndexOf("e"));

		//We can find the length of our string
		System.out.println("Length of name is " + name.length());

		//We can get just part of the string using substring
		//substring has two options:
		//1. Provide the start index and the index it goes up to but does not include
		//2. Provide only the start index and then it will take all characters up until the end of the string

		//Example of option 1:
		String tech = name.substring(0, 4);
		System.out.println("Option 1 Substring is " + tech);

		//Example of option 2
		int indexElevatorBegins= name.indexOf("Elevator");
		String substring2 = name.substring(indexElevatorBegins);
		System.out.println("Option 2 Substring is: " + substring2);

		//Replace any instances of a string with a different string
		System.out.println("Replacing spaces with nothing: " + name.replace(" ", ""));
		System.out.println("Replacing e with 3: " + name.replace("e", "3"));

		//If we want to remove blank spaces from the end or beginning of a string:
		String padding = "          Tech Elevator          ";
		System.out.println("No trim: " + padding);
		System.out.println("Trim: " + padding.trim());

		//If we want to split a string into an array
		String groceries = "milk,bread,eggs";
		String[] groceryList = groceries.split(",");

		//Or if we are starting out with an array and want to combine it all into a string
		String[] names = {"Christopher", "Claire", "Jim", "Jane"};
		System.out.println("Join example: " + String.join(" & ", names));

		//Does our name include le?
		System.out.println("Name includes le: " + name.contains("le"));

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
