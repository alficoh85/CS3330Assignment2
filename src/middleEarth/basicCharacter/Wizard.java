package middleEarth.basicCharacter;

public class Wizard extends MiddleEarthCharacter{
	/**
	 * Parameterized constructor for wizard
	 * @param name
	 * @param health
	 * @param power
	 */
	public Wizard(String name, double health, double power) {
        super(name, power, power);
    }

	/**
	 * Method that attacks as a wizard
	 * @param target
	 * @return
	 */
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Wizard || target instanceof Human) {
            return false; 
        }

        double damage = (target instanceof Dwarf) ? this.power * 1.5 : this.power;
        target.setHealth(target.getHealth() - damage);
        return true;
    }

    /**
	 * Method that returns the String "Wizard"
	 * @return
	 */
    @Override
    public String getRace() {
        return "Wizard";
    }
}