package middleEarth.basicCharacter;

public class Elf extends MiddleEarthCharacter{
	/**
	 * Parameterized constructor for elf
	 * @param name
	 * @param health
	 * @param power
	 */
	public Elf(String name, double health, double power) {
        super(name, health, power);
    }

	/**
	 * Method that attacks as an elf
	 * @param target
	 * @return
	 */
    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Elf || target instanceof Dwarf) {
        	System.out.println("Attack was ineffective!");
            return false; 
        }

        double damage = (target instanceof Orc) ? this.power * 1.5 : this.power;
        if (target instanceof Orc) {
        	System.out.println("Attack was very effective!");
        }
        else {
        	System.out.println("Attack successful!");
        }
        target.setHealth(target.getHealth() - damage);
        return true;
    }

    /**
	 * Method that returns the String "Elf"
	 * @return
	 */
    @Override
    public String getRace() {
        return "Elf";
    }
}
