package middleEarth.manager;

import middleEarth.basicCharacter.MiddleEarthCharacter;

public class CharacterManager {
	private MiddleEarthCharacter[] characters;
	private int size;
	
	public CharacterManager() {
		this.characters = new MiddleEarthCharacter[5];
		this.size = 0;
	}
	
	public boolean addCharacter(MiddleEarthCharacter c) {
		if(size == characters.length) {
			resizeArray();
		}
		characters[size++] = c;
		return true;
	}
	
	private void resizeArray() {
		MiddleEarthCharacter[] newArray = new MiddleEarthCharacter[characters.length * 2];
		System.arraycopy(characters, 0, newArray, 0, characters.length);
		characters = newArray;
	}
	
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i=0; i<size;i++) {
			if(characters[i].getName().equals(name)) {
				return characters[i];
			}
		}
		return null;
	}
	
	public boolean updateCharacter(String name, double health, double power) {
		MiddleEarthCharacter character = getCharacter(name);
		if(character != null) {
			character.setHealth(health);
			character.setPower(power);
			return true;
		}
		return false;
	}
	
	public boolean deleteCharacter(String name) {
		for(int i=0; i<size;i++) {
			if(characters[i].getName().equals(name)) {
				for(int j=i;j<size-1;j++) {
					characters[j] = characters[j+1];
				}
				characters[--size] = null;
				return true;
			}
		}
		return false;
	}
	
	public void displayAllCharacters() {
		for(int i=0; i<size; i++) {
			characters[i].displayInfo();
			System.out.println();
		}
	}
	
	public MiddleEarthCharacter[] getAllCharacters() {
		MiddleEarthCharacter[]activeCharacters = new MiddleEarthCharacter[size];
		System.arraycopy(characters, 0, activeCharacters, 0, size);
		return activeCharacters;
	}
}
