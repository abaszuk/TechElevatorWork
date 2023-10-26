package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		//1. Create a new class Cat that extends FarmAnimal but will not allow any
		//other classes to inherit from it

		//2. Make it so that the getPrice() method in Pig cannot be overridden by any
		//future classes that inherit from it
		Piglet piglet = new Piglet();
		piglet.getPrice();

		//3. Make FarmAnimal unable to be instantiated on its own

		//FarmAnimal animal = new FarmAnimal("","");

		Singable[] singables =
				new Singable[] {new Cow(), new Chicken(), new Pig(), new Tractor()};

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}