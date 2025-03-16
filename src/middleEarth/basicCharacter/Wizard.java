package middleEarth.basicCharacter;

public class Wizard extends MiddleEarthCharacter{
	/**
	 * Parameterized constructor for wizard
	 * @param name
	 * @param health
	 * @param power
	 */
	public Wizard(String name, double health, double power) {
        super(name, health, power);
    }

	/**
	 * Method that attacks as a wizard
	 * @param target
	 * @return
	 */
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Wizard || target instanceof Human) {
        	System.out.println("Attack was ineffective!");
            return false; 
        }

        double damage = (target instanceof Dwarf) ? this.power * 1.5 : this.power;
        if (target instanceof Dwarf) {
        	System.out.println("Attack was very effective!");
        }
        else {
        	System.out.println("Attack successful!");
        }
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