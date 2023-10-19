package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//When initializing a map remember we need to specify
		// the data type for both the key and the value. They can be the same or different
		//but we have to be explicit about both

		//In this case, the key is an Integer and the value will be a String (name of store)
		Map<Integer, String> mallDirectory = new HashMap<>();

		Map<String, String> snackMachine = new HashMap<>();

		Map<Integer, Double> intDoubleMap = new HashMap<>();

		//MAPS BY DEFAULT DO NOT KEEP ORDER! WE HAVE TO USE SPECIAL IMPLEMENTATION
		//IF WE WANT TO PRESERVE ANY TYPE OF ORDER

		//if we want to sort something numerically or alphabetically we
		//can use a tree map implementation
		Map<Integer, String> treeMap = new TreeMap<>();

		//If we want to just preserve the order that items were added
		//we can use a linked list
		Map<Integer,String> linkedList = new LinkedHashMap<>();



		//If we want to add new key value pairs to our map
		mallDirectory.put(118,"Gamestop");
		mallDirectory.put(120, "Starbucks");
		mallDirectory.put(125, "Sbarro");
		mallDirectory.put(130, "Starbucks");

		//All keys must be distinct and they are case sensitive but values can be duplicated

		//if we want to retrieve any of our values we simply use our key
		String store = mallDirectory.get(125);
		System.out.println("The store at 125 is " + store);

		//if we want to update a value at a particular key we just call .put again
		mallDirectory.put(125, "Chipotle");
		store = mallDirectory.get(125);
		System.out.println("The store at 125 is " + store);

		//if we want to see how many elements are in our map we can .size
		System.out.println("How many records are in our map? " + mallDirectory.size());

		//if we want to remove a record
		mallDirectory.remove(130);
		System.out.println("How many records are in our map? " + mallDirectory.size());

		//If we want to loop through our map looking at each key value pair
		//Map.Entry<Integer,String> entry represents the individual key-value pair that we are currently looking at
		//mallDirectory.entrySet() is the iterable collection that we can walk through
		for (Map.Entry<Integer,String> entry : mallDirectory.entrySet()){

			//if we want the key
			Integer key = entry.getKey();

			//If we want the value
			String value = entry.getValue();

			System.out.println("Key: " + key + " Value: " + value);
		}

		//if you want to only walk through the keys
		for (Integer key : mallDirectory.keySet()){
			System.out.println("Key: " + key);
		}

		//if we want to only walk through the values
		for (String value : mallDirectory.values()){
			System.out.println("Value: " + value);
		}

		//if we want to check if a map already has a key
		System.out.println("Do we already have key 125? " + mallDirectory.containsKey(125));

		//if we want to check if we already have a value
		System.out.println("Do we already have a Chipotle? " + mallDirectory.containsValue("Chipotle"));


		//We can get creative with different collections containing different collections
		Map<String, List<String>> nflTeams = new HashMap<>();

		List<String> pittsburgh = Arrays.asList(new String[]{"Hines Ward", "Player 2", "Player 3"});
		nflTeams.put("Pittsburgh Steelers", pittsburgh);

		//sets are like lists except they cannot have any duplicates and will ignore any redundant values we try to add
		Set<String> mySet = new HashSet<>();
		mySet.add("Alex");
		mySet.add("Alex");
		mySet.add("Alex");
		System.out.println("Values in my set: ");
		for (String value : mySet){
			System.out.println(value);
		}

		countComics();

		Map<String,Integer> fries = new HashMap<>();
		fries.put("Daughter1",25);
		fries.put("Daughter2", 10);

		fries = evenlyDivideFrenchFries(fries);

		for (Map.Entry<String, Integer> entry : fries.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}


	}
	public static Map<String, Integer> evenlyDivideFrenchFries(Map<String,Integer> fries){
		int daughter1fries = fries.get("Daughter1");
		int daughter2fries = fries.get("Daughter2");

		int difference = daughter1fries - daughter2fries;

		//if one daighter has significantly more fries than the other then divide evenly
		if (difference > 10){

			int totalFires = daughter1fries + daughter2fries;
			int half = totalFires/2;

			//keep in mind we are using int so we are losing a decimal
			fries.put("Daughter1", half);
			fries.put("Daughter2", totalFires - half);

		}
		return fries;
	}

	public static Map<String, Integer> countComics(){

		List<String> comics = new ArrayList<>();
		comics.add("Spiderman");
		comics.add("Batman");
		comics.add("Spiderman");
		comics.add("Batman");
		comics.add("X-Men");

		//how can I take my list and turn it into a map
		//where the key will be the comic characters and the value
		//will be the total number of comics i have related to that character
		Map<String, Integer> comicMap = new HashMap<>();
		for (String comic : comics){

			//do I already have an entry for this character?
			if (comicMap.containsKey(comic)){
				//we already have an entry so i just want to update the count

				//we will pass the key(comit, represneting spiderman or batman etc.) to
				//our map, and get the corresponding value
				Integer currentCount = comicMap.get(comic);
				//increment our count
				currentCount++;

				//update our map
				comicMap.put(comic,currentCount);

			} else {
				//We dont have an entry yet so create one
				comicMap.put(comic,1);
			}

		}
		return comicMap;
	}
}
