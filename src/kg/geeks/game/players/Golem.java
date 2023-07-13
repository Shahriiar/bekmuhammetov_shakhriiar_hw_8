package kg.geeks.game.players;

public class Golem extends Hero {

    private int takingDamage;

    private static final double DAMAGE_SHARE_FACTOR = 0.2;

    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.HERO_DEFENCE, "Golem");
    }

    private void golemApplyPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0){
            boss.setInitialDamage((int) (boss.getDamage() * 0.8));
            boss.setCheckGolem(true);
        }boss.setCheckGolem(false);
        int damageShare = (int) (boss.getDamage() * DAMAGE_SHARE_FACTOR);

        takingDamage = damageShare * heroes.length;
        this.setHealth(this.getHealth() - takingDamage);

    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        golemApplyPower(boss, heroes);
    }

    @Override
    public String toString() {
        if (this.getHealth() > 0) {
            return super.toString() + " --> " + takingDamage;
        } else {
            return super.toString();
        }
    }
}
