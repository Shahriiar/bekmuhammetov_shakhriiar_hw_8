package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Boss extends GameEntity {
    private SuperAbility defence;
    private boolean checkGolem = false;
    private boolean checkThor = false;
    private int initialDamage;

    public void setInitialDamage(int initialDamage) {
        this.initialDamage = initialDamage;
    }

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public SuperAbility getDefence() {
        return defence;
    }

    public void chooseDefence(Hero[] heroes) {
        int randomIndex = RPG_Game.random.nextInt(heroes.length);
        this.defence = heroes[randomIndex].getAbility();
    }

    public void attack(Hero[] heroes) {

        if (checkGolem) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() - initialDamage);
                }
            }
            checkGolem = false;

        } else {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }

        }

    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " defence: " + this.defence;
    }

    public void setCheckGolem(boolean checkGolem) {
        this.checkGolem = checkGolem;
    }

    public void setCheckThor(boolean checkThor) {
        this.checkThor = checkThor;
    }

    public boolean isCheckThor() {
        return checkThor;
    }
}
