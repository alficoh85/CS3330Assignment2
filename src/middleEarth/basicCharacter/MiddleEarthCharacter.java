package middleEarth.basicCharacter;


public abstract class MiddleEarthCharacter {
	/**
	 * MiddleEarthCharacter's instance variables
	 */
	protected String name;
	protected double health;
	protected double power;
	
	/**
	 * Parameterized constructor
	 * @param name
	 * @param health
	 * @param power
	 */
	public void middleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.health = health;
		this.power = power;
	}
	
	/**
	 * Abstract method to attack another character
	 * @param target
	 * @return
	 */
	public abstract boolean attack(MiddleEarthCharacter target);
	
	/**
	 * Abstract method to return a String of the character's race
	 * @return
	 */
	public abstract String getRace();
	
	/**
	 * Concrete method that prints a character's information
	 */
	public void displayInfo() {
		System.out.println("Name: " + name);
		System.out.println("Race: " + getRace());
		System.out.println("Health: " + health);
		System.out.println("Power: " + power);
	}
	
	/**
	 * Accessor method for name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Accessor method for health
	 * @return
	 */
	public double getHealth() {
		return health;
	}
	
	/**
	 * Accessor method for power
	 * @return
	 */
	public double getPower() {
		return power;
	}
	
	/**
	 * Mutator method for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Mutator method for health
	 * @param health
	 */
	public void setHealth(double health) {
		this.health = health;
	}
	
	/**
	 * Mutator method for power
	 * @param power
	 */
	public void setPower(double power) {
		this.power = power;
	}
}
	
	