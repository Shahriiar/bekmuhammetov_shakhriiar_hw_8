package kg.geeks.game.players;

public class Witcher extends Hero {
    public Witcher(int health, String name) {
        super(health, 0, SuperAbility.SACRIFICE_LIFE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0 && heroes[i] != this && this.getHealth() > 0) {
                heroes[i].setHealth(this.getHealth());
                this.setHealth(0);
            }
        }
    }
}
