package middleEarth.basicCharacter;

public class Elf extends characterAbstract{
	public Elf(String name, double health, double power) {
        super();
    }

    @Override
    public boolean attack(characterAbstract target) {
        if (target instanceof Elf || target instanceof Dwarf) {
            return false; 
        }

        double damage = (target instanceof Orc) ? this.power * 1.5 : this.power;
        target.setHealth(target.getHealth() - damage);
        return true;
    }

    @Override
    public String getRace() {
        return "Elf";
    }
}
