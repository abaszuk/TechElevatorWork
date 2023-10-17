package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		House blueHouse1 = new House();
		blueHouse1.setColor("Blue");

		House redHouse1 = new House();
		redHouse1.setColor("Red");




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

		//you can check if a string begins or ends with any other string of letters
		boolean startsWithTech = name.startsWith("Tech");
		System.out.println("Starts with Tech: " + startsWithTech);

		boolean startsWithLowerTech = name.startsWith("tech");
		System.out.println("Starts with Tech: " + startsWithLowerTech);

		boolean endsWithElevator = name.endsWith("Elevator");
		System.out.println("Ends with Elevator: " + endsWithElevator);

		//We can force lower or upper case
		System.out.println("Uppercase: " + name.toUpperCase());

		//we can uyse those methods to make things case insensitive
		boolean endsWIthElevator2 = name.toLowerCase().endsWith("elevator");
		System.out.println("ends with elevator case insensitive: " + endsWIthElevator2);


		//if we want the value at a certain index
		System.out.println("Character at index 7: " + name.charAt(7));

		//if we want to find where "elevator" starts
		System.out.println("Elevator starts at index: " + name.indexOf("Elevator"));

		System.out.println("Where is the last e that shows up: " + name.lastIndexOf("e"));

		//we can find the length of our string
		System.out.println("length of name is " + name.length());

		//we can get just part of the string using substring
		//substring has 2 options
		//1. provide the start index and the index it goes up to but does not include
		//2. provide only the start index and then it will take all characters up until the end of the string

		//example of option 1
		String tech = name.substring(0, 4);
		System.out.println("option 1 substring is " + tech);

		//example Option 2
		String elevator = name.substring(5);
		System.out.println("option 2 substring is " + elevator);

		//if we want to remove the blank spaces from the end or beginning of a string
		String padding = "      Tech Elevator         ";
		System.out.println("no trim: " + padding);
		System.out.println("trim: " + padding.trim());

		//if we want to split a string into an array
		String groceries = "milk,bread,eggs";
		String[] groceryList = groceries.split(",");

		//or if we are starting out with an array and want to combine it all into a string
		String[] names = {"alex", "jim", "jane"};
		System.out.println("Join example: " + String.join(" & ", names));

		//Does our name include le?
		System.out.println("name includes le: " + name.contains("le"));


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
