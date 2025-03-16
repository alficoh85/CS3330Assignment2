package middleEarth.basicCharacter;

public class Orc extends MiddleEarthCharacter{
	/**
	 * Parameterized constructor for orc
	 * @param name
	 * @param health
	 * @param power
	 */
	public Orc(String name, double health, double power) {
        super(name, health, power);
    }

	/**
	 * Method that attacks as an orc
	 * @param target
	 * @return
	 */
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Orc || target instanceof Elf) {
        	System.out.println("Attack was ineffective!");
            return false; 
        }

        double damage = (target instanceof Human) ? this.power * 1.5 : this.power;
        if (target instanceof Human) {
        	System.out.println("Attack was very effective!");
        }
        else {
        	System.out.println("Attack successful!");
        }
        target.setHealth(target.getHealth() - damage);
        return true;
    }

    /**
	 * Method that returns the String "Orc"
	 * @return
	 */
    @Override
    public String getRace() {
        return "Orc";
    }
}