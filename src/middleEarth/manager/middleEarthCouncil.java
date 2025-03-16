package middleEarth.manager;

public class MiddleEarthCouncil {
	/**
	 * Instance variables for the MiddleEarthCouncil Singleton class
	 */
	private static MiddleEarthCouncil instance;
	private CharacterManager characterManager;
	
	/**
	 * Private default constructor to make sure it can only be initialized in the MiddleEarthCouncil itself
	 */
	private MiddleEarthCouncil() {
		characterManager = new CharacterManager();
	}
	
	/**
	 * Method to create and return the MiddleEarthCouncil instance or to return the instance already created
	 * @return
	 */
	public static MiddleEarthCouncil getInstance() {
		if(instance == null) {
			instance = new MiddleEarthCouncil();
		}
		return instance;
	}
	
	/**
	 * Method to return the instance of CharacterManager
	 * @return
	 */
	public CharacterManager getCharacterManager() {
		return characterManager;
	}
}
