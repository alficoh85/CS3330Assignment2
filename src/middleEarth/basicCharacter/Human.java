package middleEarth.basicCharacter;

public class Human extends MiddleEarthCharacter{
	/**
	 * Parameterized constructor for human
	 * @param name
	 * @param health
	 * @param power
	 */
	public Human(String name, double health, double power) {
        super(name, health, power);
    }

	/**
	 * Method that attacks as a human
	 * @param target
	 * @return
	 */
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Human || target instanceof Orc) {
        	System.out.println("Attack was ineffective!");
            return false; 
        }

        double damage = (target instanceof Wizard) ? this.power * 1.5 : this.power;
        if (target instanceof Wizard) {
        	System.out.println("Attack was very effective!");
        }
        else {
        	System.out.println("Attack successful!");
        }
        target.setHealth(target.getHealth() - damage);
        return true;
    }

    /**
	 * Method that returns the String "Human"
	 * @return
	 */
    @Override
    public String getRace() {
        return "Human";
    }
}