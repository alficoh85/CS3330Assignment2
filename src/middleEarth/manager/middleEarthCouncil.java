package middleEarth.manager;

public class middleEarthCouncil {
	private static middleEarthCouncil instance;
	private characterManager characterManager;
	
	private middleEarthCouncil() {
		characterManager = new characterManager();
	}
	
	public static middleEarthCouncil getInstance() {
		if(instance == null) {
			instance = new middleEarthCouncil();
		}
		return instance;
	}
	
	public characterManager getCharacterManager() {
		return characterManager;
	}
}
