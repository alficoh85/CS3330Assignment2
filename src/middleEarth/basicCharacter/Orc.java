package middleEarth.basicCharacter;

public class Orc extends MiddleEarthCharacter{
	public Orc(String name, double health, double power) {
        super();
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
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