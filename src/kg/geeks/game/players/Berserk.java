package kg.geeks.game.players;

public class Berserk extends Hero{
    private int blockedDamage;


    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        setBlockedDamage(boss.getDamage() / 5);
        if (this.getHealth() > 0){
            this.setHealth(getHealth() + blockedDamage);
            boss.setHealth(boss.getHealth() - this.getDamage() + blockedDamage);
        }
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }
    @Override
    public String toString() {
        if (this.getHealth() > 0){
            return super.toString() + " --> " + (this.getDamage() + this.blockedDamage);
        }else {
            return super.toString();
        }
    }
}
