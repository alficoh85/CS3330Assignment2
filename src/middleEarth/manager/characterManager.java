package middleEarth.manager;

import middleEarth.basicCharacter.characterAbstract;

public class characterManager {
	private characterAbstract[] characters;
	private int size;
	
	public characterManager() {
		this.characters = new characterAbstract[5];
		this.size = 0;
	}
	
	public boolean addCharacter(characterAbstract c) {
		if(size == characters.length) {
			resizeArray();
		}
		characters[size++] = c;
		return true;
	}
	
	private void resizeArray() {
		characterAbstract[] newArray = new characterAbstract[characters.length * 2];
		System.arraycopy(characters, 0, newArray, 0, characters.length);
		characters = newArray;
	}
	
	public characterAbstract getCharacter(String name) {
		for(int i=0; i<size;i++) {
			if(characters[i].getName().equals(name)) {
				return characters[i];
			}
		}
		return null;
	}
	
	public boolean updateCharacter(String name, double health, double power) {
		characterAbstract character = getCharacter(name);
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
	
	public characterAbstract[] getAllCharacters() {
		characterAbstract[]activeCharacters = new characterAbstract[size];
		System.arraycopy(characters, 0, activeCharacters, 0, size);
		return activeCharacters;
	}
}
