package middleEarth.manager;

public class characterManager {
	private middleEarthCharacter[] characters;
	private int sie;
	
	public characterManager() {
		this.characters = new middleEarthCharacter[5];
		this.size = 0;
	}
	
	public boolean addCharacter(middleEarthCharacter c) {
		if(size == characters.length) {
			resizeArray();
		}
		characters[size++] = c;
		return true;
	}
	
	private void resizeArray() {
		
	}
}
