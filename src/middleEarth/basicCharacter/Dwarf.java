package middleEarth.basicCharacter;

public class Dwarf extends characterAbstract{
	public Dwarf(String name, double health, double power) {
        super();
    }

    @Override
    public boolean attack(characterAbstract target) {
        if (target instanceof Dwarf || target instanceof Wizard) {
            return false; 
        }

        double damage = (target instanceof Elf) ? this.power * 1.5 : this.power;
        target.setHealth(target.getHealth() - damage);
        return true;
    }

    @Override
    public String getRace() {
        return "Dwarf";
    }
}