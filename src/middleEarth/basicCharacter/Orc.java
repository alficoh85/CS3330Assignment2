package middleEarth.basicCharacter;

public class Orc extends MiddleEarthCharacter{
	/**
	 * Parameterized constructor for orc
	 * @param name
	 * @param health
	 * @param power
	 */
	public Orc(String name, double health, double power) {
        super(name, power, power);
    }

	/**
	 * Method that attacks as an orc
	 * @param target
	 * @return
	 */
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Orc || target instanceof Elf) {
            return false; 
        }

        double damage = (target instanceof Human) ? this.power * 1.5 : this.power;
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