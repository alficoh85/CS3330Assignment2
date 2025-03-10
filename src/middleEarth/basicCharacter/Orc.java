package middleEarth.basicCharacter;

public class Orc extends characterAbstract{
	public Orc(String name, double health, double power) {
        super(name, health, power);
    }

    @Override
    public boolean attack(characterAbstract target) {
        if (target instanceof Orc || target instanceof Elf) {
            return false; 
        }

        double damage = (target instanceof Human) ? this.power * 1.5 : this.power;
        target.setHealth(target.getHealth() - damage);
        return true;
    }

    @Override
    public String getRace() {
        return "Orc";
    }
}