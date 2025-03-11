package middleEarth.manager;

public class middleEarthCouncil {
	private static middleEarthCouncil instance;
	private characterManager characterManager;
	
	private middleEarthCouncil() {
		characterManager = new CharacterManager();
	}
}
