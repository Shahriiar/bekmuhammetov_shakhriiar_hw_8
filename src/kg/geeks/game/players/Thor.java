package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Thor extends Hero{

    private boolean skipStunned;
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.SKIP_STUNNED, "Thor");
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0){
            skipStunned = RPG_Game.random.nextBoolean();
            boss.setCheckThor(skipStunned);
        }
    }

    public boolean isSkipStunned() {
        return skipStunned;
    }
    @Override
    public String toString() {
        if (this.getHealth() > 0){
            return super.toString() + " --> " + (skipStunned);
        }else {
            return super.toString();
        }
    }
}
