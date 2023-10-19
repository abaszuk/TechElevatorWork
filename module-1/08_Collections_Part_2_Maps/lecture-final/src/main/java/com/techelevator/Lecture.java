package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//When initializing a map, remember we need to specify
		//the data type for both the key and the value. They can be the same or different
		//but we have to explicit about both

		//In this case, the key is an Integer and the value will be a String (name of the store)
		Map<Integer, String> mallDirectory = new HashMap<>();

		Map<String, String> snackMachine = new HashMap<>();

		Map<Integer, Double> intDoubleMap = new HashMap<>();

		//MAPS 	BY DEFAULT DO NOT KEEP ORDER!!! WE HAVE TO USE SPECIAL IMPLEMENTATIONS IF
		//WE WANT TO PRESERVE ANY TYPE OF ORDER

		//If we want to sort something numerically or alphabetically we
		//can use a tree map implementation
		Map<Integer, String> treeMap = new TreeMap<>();

		//If we want to just preserve the order that items were added
		//we can use a linked hash map
		Map<Integer, String> linkedList = new LinkedHashMap<>();



		//If we want to add new key value pairs to our map
		mallDirectory.put(118, "Gamestop");
		mallDirectory.put(120, "Starbucks");
		mallDirectory.put(125, "Sbarro");
		mallDirectory.put(130, "Starbucks");
		mallDirectory.put(145, "AMC Theater");
		mallDirectory.put(147, "Buckle");
		mallDirectory.put(150, "FYE");
		mallDirectory.put(155, "Hot Topic");

		//All keys must be distinct (and they are case sensitive), but values can be duplicated

		//if we want to retrieve any of our values, we simply use our key
		String store = mallDirectory.get(125);
		System.out.println("The store 125 is " + store);

		//If we want to update a value at a particular key, we just call .put again
		mallDirectory.put(125, "Chipotle");

		store = mallDirectory.get(125);
		System.out.println("The store 125 is " + store);

		//If we want to see how many elements are in our map, we can .size()
		System.out.println("How many records are in our map? " + mallDirectory.size());

		//If we want to remove a record
		mallDirectory.remove(130);
		System.out.println("How many records are in our map? " + mallDirectory.size());


		//If we want to loop through our map looking at each key value pair:
		//Map.Entry<Integer, String> entry represents the individual key-value pair that we are currently looking at
		//mallDirectory.entrySet() is the iterable collection that we can walk through
		for(Map.Entry<Integer, String> entry : mallDirectory.entrySet()) {

			//If we want the key
			Integer key = entry.getKey();

			//If we want the value
			String value = entry.getValue();

			System.out.println("Key: " + key + " Value: " + value);
		}


		//If you want to only walk through the keys
		for(Integer key : mallDirectory.keySet()){
			System.out.println("Key: " + key);
		}

		//If we want to only walk through the values
		for(String value : mallDirectory.values()){
			System.out.println("Value: " + value);
		}

		//If we want to check if a map already has a key
		System.out.println("Do we already have key 125: " + mallDirectory.containsKey(125));

		//If we want to check if we already have a value
		System.out.println("Do we already have a Chipotle: " + mallDirectory.containsValue("Chipotle"));


		//We can get creative with different collections containing different collections
		Map<String, List<String>> nflTeams = new HashMap<>();

		List<String> pittsburgh = Arrays.asList(new String[]{"Hines Ward", "Player 2", "Player 3"});
		nflTeams.put("Pittsburgh Steelers", pittsburgh);


		//Sets are like lists, except they cannot have any duplicates and will ignore any redundant values we try to add
		Set<String> mySet = new HashSet<>();
		mySet.add("Christopher");
		mySet.add("Christopher");
		mySet.add("Christopher");
		mySet.add("christopher");

		System.out.println("Values in my set:");
		for(String value : mySet){
			System.out.println(value);
		}

		Map<String, Integer> comics = countComics();
		for(Map.Entry<String, Integer> entry : comics.entrySet()){
			//System.out.println("Comic: " + entry.getKey() + "  Count: " + entry.getValue());
			System.out.println(entry);
		}

		Map<String, Integer> fries = new HashMap<>();
		fries.put("Daughter1",25);
		fries.put("Daughter2", 10);

		fries = evenlyDivideFrenchFriesWTax(fries);

		for(Map.Entry<String, Integer> entry : fries.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

	public static Map<String, Integer> evenlyDivideFrenchFriesWTax(Map<String, Integer> fries) {

		int daughter1Fries = fries.get("Daughter1");
		int daughter2Fries = fries.get("Daughter2");

		int difference = daughter1Fries - daughter2Fries;

		//If one daughter has significantly more fries than the other, then divide evenly
		if(difference > 10) {

			int totalFries = daughter1Fries + daughter2Fries;

			fries.put("Dad", 5);
			totalFries -= 5;

			int half = totalFries / 2;

			//Keep in mind, if we're using ints then if we have a decimal, we're losing the decimal
			fries.put("Daughter1", half);
			fries.put("Daughter2", totalFries - half);

		}

		return fries;
	}

	public static Map<String, Integer> evenlyDivideFrenchFries(Map<String, Integer> fries) {

		int daughter1Fries = fries.get("Daughter1");
		int daughter2Fries = fries.get("Daughter2");

		int difference = daughter1Fries - daughter2Fries;

		//If one daughter has significantly more fries than the other, then divide evenly
		if(difference > 10) {

			int totalFries = daughter1Fries + daughter2Fries;
			int half = totalFries / 2;

			//Keep in mind, if we're using ints then if we have a decimal, we're losing the decimal
			fries.put("Daughter1", half);
			fries.put("Daughter2", totalFries - half);

		}

		return fries;
	}

	//Creating a map as we iterate through a list
	public static Map<String, Integer> countComics(){

		List<String> comics = new ArrayList<>();
		comics.add("Spiderman");
		comics.add("Batman");
		comics.add("Spiderman");
		comics.add("Spiderman");
		comics.add("Batman");
		comics.add("X-Men");

		//How can I take my list and turn it into a map
		//where the key will be the comic character, and the value
		//will be the total number of comics I have related to that character
		Map<String, Integer> comicMap = new HashMap<>();
		for(String comic : comics) {

			//do I already have an entry for this character?
			if(comicMap.containsKey(comic)) {
				//we already have an entry so I just want to update the count

				//we will pass the key (comic, representing "Spiderman" or "Batman", etc.) to
				//our map, and get the corresponding value (our count) back
				Integer currentCount = comicMap.get(comic);

				//increment our count
				currentCount++;

				//update our map
				comicMap.put(comic, currentCount);

			} else {
				//We don't have an entry yet, so create one
				comicMap.put(comic, 1);
			}


		}
		return comicMap;

	}

}
