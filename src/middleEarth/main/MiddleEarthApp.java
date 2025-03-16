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
		System.out.println("Welcome to the Middle-earth character manager!\n");
		while (exit) {
			System.out.println("Please choose an option.");
			System.out.println("1. Add a new character");
			System.out.println("2. View all characters");
			System.out.println("3. Update an existing character");
			System.out.println("4. Delete an existing character");
			System.out.println("5. Execute all characters' attack actions");
			System.out.println("6. Exit\n\n");
			choice = input.nextInt();
			if (choice < 1 || choice > 6) {
				System.out.println("Invalid input.\n");
			}
			if (choice == 1) {
				MiddleEarthCharacter characterToAdd = null;
				System.out.println("Please enter the name of the character you want to add: ");
				input.nextLine();
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
				manager.displayAllCharacters();
			}
			if (choice == 3) {
				System.out.println("Please enter the name of the existing character you would like to update: ");
				input.nextLine();
				String characterNameToUpdate = input.nextLine();
				System.out.println("Please enter the name you would like to update to (enter current name to keep name as is): ");
				String updateName = input.nextLine();
				System.out.println("Please enter the health you would like to update to (enter current name to keep health as is): ");
				int updateHealth = input.nextInt();
				System.out.println("Please enter the power you would like to update to (enter current name to keep power as is): ");
				int updatePower = input.nextInt();
				MiddleEarthCharacter characterToUpdate = manager.getCharacter(characterNameToUpdate);
				boolean updateSuccess = manager.updateCharacter(characterToUpdate, updateName, updateHealth, updatePower);
				if (updateSuccess == false) {
					System.out.println("Update failed. Please enter the name of a valid character or make sure you made changes.");
				} 
				else {
					System.out.println("Update successful!");
				}
			}
			if (choice == 4) {
				input.nextLine();
				System.out.println("Please enter the name of the existing character you would like to delete: ");
				String deleteName = input.nextLine();
				MiddleEarthCharacter characterToDelete = manager.getCharacter(deleteName);
				boolean deleteSuccess = manager.deleteCharacter(characterToDelete);
				if (deleteSuccess == false) {
					System.out.println("Delete failed. Please enter the name of a valid character.");
				}
				else {
					System.out.println("Delete successful!");
				}
			}
			if (choice == 5) {
				input.nextLine();
				MiddleEarthCharacter[] characterArray = manager.getAllCharacters();
				if (characterArray.length > 1) {
					for (int i = 0; i<characterArray.length; i++) {
						System.out.println("Please enter the name of the character for " + characterArray[i].getName() + " to attack: ");
						String victimName = input.nextLine();
						boolean victimFound = false;
						for (int j = 0; j<characterArray.length && victimFound == false; j++) {
							if (i != j) {
								if (victimName.equals(characterArray[j].getName())) {
									characterArray[i].attack(characterArray[j]);
									victimFound = true;
								}
							}
						}
						if (victimFound == false) {
							System.out.println("Attack failed. Please input the name of a valid character to attack.");
						}
					}
					for (int k = 0; k<characterArray.length; k++) {
						manager.updateCharacter(characterArray[k], characterArray[k].getName(), characterArray[k].getHealth(), characterArray[k].getPower());
					}
				}
				else {
					System.out.println("Cannot execute attacks, not enough characters.");
				}
			}
			if (choice == 6) {
				System.out.println("Exiting Middle-earth character manager.");
				exit = false;
			}
		}
	}
}