package com.techelevator;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		//list is an interface which means its a generic type of list
		//while arraylist is the specific implementation of list that we want to use.
		List<String> movies = new ArrayList<>();

		

		//We cannot make a list of primitives so we have to use the object
		//version of primitives that java provides
		List<Integer> numbers = new ArrayList<>();
		List<Double> doubles = new ArrayList<>();
		List<Boolean> boolenas = new ArrayList<>();
		List<Character> characters = new ArrayList<>();


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		//we can add items to a list and the order we add them is the order they are saved in
		movies.add("The Shining");
		movies.add("The Ring");
		movies.add("Blaire Witch Project");
		movies.add("Freddy vs Jason");

		for (int i = 0; i < movies.size(); i++)
			//when we were getting a value from an array we would use square brackets
			//ie  	myArray[0] to get first element
			//with list we use the .get method
			System.out.println((i+1) + ") " + movies.get(i));


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		movies.add("The Shining");
	/*
		for (int i = 0; i < movies.size(); i++){
			String movie = movies.get(i);
			System.out.println(movie);
		}

	 */

		//when we are looping through something
		//1. from start to finish
		//2. only one at a time
		//3. and we dont have to modify the list/array/string itself
		//then we can use a foreach loop
		//foreach loops only care about values not indexes
		for (String movie : movies)
			System.out.println(movie);


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		//The new value will be inserted at index 2
		//previous values will be shifter over by one not overwritten
		movies.add(2,"Halloween");

		for (String movie: movies){
			System.out.println(movie);
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		//Remove the last element from my list
		//movies.remove(5); // hardcoded as last
		movies.remove(movies.size()-1);

		//or if i wanted to remove the first one
		movies.remove(0);
		for (String movie: movies){
			System.out.println(movie);
		}



		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		//Note this is case sensitive
		System.out.println("Does the list contain 'The Ring'" + movies.contains("The Ring"));


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfRing = movies.indexOf("The Ring");
		System.out.println("Index of Ring: " + indexOfRing);

		int lastIndexOfRing = movies.lastIndexOf("The Ring");
		System.out.println("index of Ring: " + lastIndexOfRing);


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		//To go from a list to an array use toArray and delcare the array type in the parentheses
		String[] movieArray = movies.toArray(new String[movies.size()]);

		//if we want to go from an array to a list:
		String[] villains = {"Freddy", "Jason", "Michael Myers", "Ghostface"};
		List<String> villainsList = Arrays.asList(villains);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		//the sort happens in place, so it overwrites the original list order
		Collections.sort(villainsList);
		for (String villain : villainsList){
			System.out.println(villain);
		}


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(villainsList);
		for (String villain : villainsList){
			System.out.println(villain);
		}


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();




	}
}
