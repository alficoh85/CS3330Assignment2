package middleEarth.basicCharacter;

public class Wizard extends MiddleEarthCharacter{
	public Wizard(String name, double health, double power) {
        super();
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Wizard || target instanceof Human) {
            return false; 
        }

        double damage = (target instanceof Dwarf) ? this.power * 1.5 : this.power;
        target.setHealth(target.getHealth() - damage);
        return true;
    }

    @Override
    public String getRace() {
        return "Wizard";
    }
}