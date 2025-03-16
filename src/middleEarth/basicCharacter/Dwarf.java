package middleEarth.basicCharacter;

public class Dwarf extends MiddleEarthCharacter {
	/**
	 * Parameterized constructor for Dwarf
	 * @param name
	 * @param health
	 * @param power
	 */
	public Dwarf(String name, double health, double power) {
        super(name, health, power);
    }

	/**
	 * Method that attacks as a dwarf
	 * @param target
	 * @return
	 */
    @Override
    public boolean attack(MiddleEarthCharacter target) {
    	System.out.println("Attacking " + target.getName() + "...");
        if (target instanceof Dwarf || target instanceof Wizard) {
        	System.out.println("Attack was ineffective!");
            return false; 
        }

        double damage = (target instanceof Elf) ? this.power * 1.5 : this.power;
        if (target instanceof Elf) {
        	System.out.println("Attack was very effective!");
        }
        else {
        	System.out.println("Attack successful!");
        }
        target.setHealth(target.getHealth() - damage);
        return true;
    }

	/**
	 * Method that returns the String "Dwarf"
	 * @return
	 */
    @Override
    public String getRace() {
        return "Dwarf";
    }
}