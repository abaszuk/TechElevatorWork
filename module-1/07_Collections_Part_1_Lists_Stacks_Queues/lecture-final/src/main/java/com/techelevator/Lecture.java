package com.techelevator;

import java.sql.Array;
import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		//List is an interface which means its a generic type of List
		//while ArrayList is the specific implementation of List that we
		//want to use.
		List<String> movies = new ArrayList<>();

		//We cannot make a list of primitives, so we have to use the object
		//version of primitives that java provides

		//We cannot do this
		//List<int> numbers = new ArrayList<>();

		//Instead we have to do this:
		List<Integer> numbers = new ArrayList<>();
		List<Double> doubles = new ArrayList<>();
		List<Boolean> booleans = new ArrayList<>();
		List<Character> characters = new ArrayList<>();

		//No need to use special math libraries
		//Integer and Double still respond to normal operations with + - / *
		Integer num1 = 2;
		Integer num2 = 3;
		Integer sum = num1 + num2;
		System.out.println(sum);


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		//We can add items to a list and the order we add them is the order they are saved in
		movies.add("The Shining");
		movies.add("The Ring");
		movies.add("Blaire Witch Project");
		movies.add("Freddy Vs. Jason");

		//Instead of .length we need to use .size() for lists
		for(int i = 0; i < movies.size(); i++){

			//when we were getting a value from an array we would use square brackets
			//ie   myArray[0] to get the first element
			//with lists we use the .get method
			System.out.println( (i+1) + ") " + movies.get(i));
		}



		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		movies.add("The Shining");


		for(int i = 0; i < movies.size(); i++){
			String movie = movies.get(i);
			System.out.println(movie);
		}

		//When we are looping through something
		//1. From start to finish
		//2. Only one at a time
		//3. And we don't have to modify the list/array/string itself
		//Then we can use a foreach loop
		//Foreach loops only care about values, not indexes
		for(String movie : movies) {
			System.out.println(movie);
		}

		for(Integer num : numbers){
			System.out.println(num);
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		//The new value will be inserted at index 2
		//Previous values will be shifted over by one, not overwritten
		//So Blaire Witch becomes index 3 to make room for this new value at index 2
		movies.add(2, "Halloween");

		for(String movie : movies){
			System.out.println(movie);
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		//Remove the last element from my list
		//movies.remove(5); //hardcoded as last
		movies.remove(movies.size()-1);

		//or if I wanted to remove the first one
		movies.remove(0);

		for(String movie: movies){
			System.out.println(movie);
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		//Note: this is case sensitive
		System.out.println("Does the list contain 'The Ring'" + movies.contains("The Ring"));
		System.out.println("Does the list contain lowercase 'The ring'" + movies.contains("The ring"));

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfRing = movies.indexOf("The Ring");
		System.out.println("INdex of Ring: " + indexOfRing);

		int lastIndexOfRing = movies.lastIndexOf("The Ring");
		System.out.println("INdex of Ring: " + lastIndexOfRing);

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		//To go from a list to an array, use toArray and declare the array type in the parentheses
		String[] movieArray = movies.toArray(new String[movies.size()]);

		//If we want to go from an array to a list:
		String[] villains = {"Freddy", "Jason", "Michael Myers", "Ghostface"};
		List<String> villainsList = Arrays.asList(villains);

		//If we want to do it manuallly:
		List<String> villainsList2 = new ArrayList<>();
		for(String villain : villains){
			villainsList2.add(villain);
		}


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		//the sort happens in place, so it overwrites the original list order
		Collections.sort(villainsList);
		for(String villain : villainsList){
			System.out.println(villain);
		}


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(villainsList);
		for(String villain : villainsList){
			System.out.println(villain);
		}


		//Example of a stack
		Stack<String> books = new Stack<>();

		books.push("The Shining");
		books.push("It");
		books.push("Salem's Lot");
		books.push("Carrie");

		//Stacks are LIFO - meaning last in is the first out
		System.out.println(books.pop());
		System.out.println(books.pop());
		System.out.println(books.pop());
		System.out.println(books.pop());


		//Or if I want a data structure that is FIFO - first in first out (similar to the take a number at the DMV)
		Queue<String> line = new LinkedList<>();

		line.offer("Bob");
		line.offer("Jane");
		line.offer("Christopher");

		System.out.println(line.poll());
		System.out.println(line.poll());
		System.out.println(line.poll());


	}
}
