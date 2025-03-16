package middleEarth.manager;

import middleEarth.basicCharacter.MiddleEarthCharacter;

public class CharacterManager {
	/**
	 * Instance variables
	 */
	private MiddleEarthCharacter[] characters;
	private int size;
	
	/**
	 * Default constructor
	 */
	public CharacterManager() {
		this.characters = new MiddleEarthCharacter[5];
		this.size = 0;
	}
	
	/**
	 * Method to add a MiddleEarthCharacter to CharacterManager, doubles array size if full
	 * @param c
	 * @return
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {
		if(size == characters.length) {
			resizeArray();
		}
		characters[size++] = c;
		return true;
	}
	
	/**
	 * Method to allow addCharacter to resize the MiddleEarthCharacter array dynamically when full
	 */
	private void resizeArray() {
		MiddleEarthCharacter[] newArray = new MiddleEarthCharacter[characters.length * 2];
		System.arraycopy(characters, 0, newArray, 0, characters.length);
		characters = newArray;
	}
	
	/**
	 * Method that searches the characters array and returns a MiddleEarthCharacter with the name specified
	 * using the parameter name, returns null on failure to find a MiddleEarthCharacter with that name
	 * @param name
	 * @return
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i=0; i<size;i++) {
			if(characters[i].getName().equals(name)) {
				return characters[i];
			}
		}
		return null;
	}
	
	/**
	 * Method that updates a character in the manager
	 * @param character
	 * @param name
	 * @param health
	 * @param power
	 * @return
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, double health, double power) {
		if(getCharacter(character.getName()) != null) {
			for(int i=0; i<size;i++) {
				if(characters[i].getName().equals(character.getName())) {
					if (characters[i].getName() != name || characters[i].getHealth() != health || characters[i].getPower() != power) {
						characters[i].setName(name);
						characters[i].setHealth(health);
						characters[i].setPower(power);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Method that deletes a character from the manager
	 * @param name
	 * @return
	 */
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		for(int i=0; i<size;i++) {
			if(characters[i].getName().equals(character.getName())) {
				for(int j=i;j<size-1;j++) {
					characters[j] = characters[j+1];
				}
				characters[--size] = null;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to display all characters in the manager
	 */
	public void displayAllCharacters() {
		for(int i=0; i<size; i++) {
			characters[i].displayInfo();
			System.out.println();
		}
	}
	
	/**
	 * Method to return all characters in the manager
	 * @return
	 */
	public MiddleEarthCharacter[] getAllCharacters() {
		MiddleEarthCharacter[]activeCharacters = new MiddleEarthCharacter[size];
		System.arraycopy(characters, 0, activeCharacters, 0, size);
		return activeCharacters;
	}
}
