package middleEarth.basicCharacter;

public class Human extends MiddleEarthCharacter{
	public Human(String name, double health, double power) {
        super();
    }

    @Override
    public boolean attack(MiddleEarthCharacter target) {
        if (target instanceof Human || target instanceof Orc) {
            return false; 
        }

        double damage = (target instanceof Wizard) ? this.power * 1.5 : this.power;
        target.setHealth(target.getHealth() - damage);
        return true;
    }

    @Override
    public String getRace() {
        return "Human";
    }
}