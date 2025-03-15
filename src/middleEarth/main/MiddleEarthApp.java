package middleEarth.main;

import java.util.Scanner;

import middleEarth.basicCharacter.*;
import middleEarth.manager.CharacterManager;
import middleEarth.manager.MiddleEarthCouncil;

public class MiddleEarthApp {
	public static void main(String[] args) {
		boolean exit = true;
		Scanner input = new Scanner(System.in);
		int choice = -1;
		MiddleEarthCouncil council = MiddleEarthCouncil.getInstance();
		CharacterManager manager = council.getCharacterManager();
		MiddleEarthCharacter characterToAdd = null;
		while (exit) {
			System.out.println("Choice text: ");
			choice = input.nextInt();
			if (choice < 1 || choice > 6) {
				System.out.println("Invalid input.");
			}
			if (choice == 1) {
				System.out.println("Please enter the name of the character you want to add: ");
				String addName = input.nextLine();
				System.out.println("Please enter the number of the race of the character you would like to add. ");
				System.out.println("1. Dwarf");
				System.out.println("2. Elf");
				System.out.println("3. Human");
				System.out.println("4. Orc");
				System.out.println("5. Wizard");
				int raceChoice = input.nextInt();
				while (raceChoice < 1 || raceChoice > 5) {
					System.out.println("Invalid input. Please select a valid number.");
					System.out.println("1. Dwarf");
					System.out.println("2. Elf");
					System.out.println("3. Human");
					System.out.println("4. Orc");
					System.out.println("5. Wizard");
					raceChoice = input.nextInt();
				}
				System.out.println("Please enter the health points of your character: ");
				double addHealth = input.nextDouble();
				System.out.println("Please enter the power of your character: ");
				double addPower = input.nextDouble();
				switch (raceChoice) {
					case 1:
						characterToAdd = new Dwarf(addName, addHealth, addPower);
						break;
					case 2:
						characterToAdd = new Elf(addName, addHealth, addPower);
						break;
					case 3:
						characterToAdd = new Human(addName, addHealth, addPower);
						break;
					case 4:
						characterToAdd = new Orc(addName, addHealth, addPower);
						break;
					case 5:
						characterToAdd = new Wizard(addName, addHealth, addPower);
						break;
				}
				if (characterToAdd != null) {
					manager.addCharacter(characterToAdd);
				}
			}
			if (choice == 2) {
				//To do: add choices 2-5 and update print at the beginning of the main
			}
			if (choice == 6) {
				exit = false;
			}
		}
	}
}