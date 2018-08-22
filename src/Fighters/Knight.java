package Fighters;

import java.util.Random;

public class Knight extends ArenaFighters {
    protected float shield;

    public Knight(String name, float health, float damage, float armor, float shield) {
        super(name, health, damage, armor);
        this.shield = shield;
    }

    public void attack(ArenaFighters arenaFighter) {
        arenaFighter.damaged(this.damage);
    }

    protected void damaged(float damageTaken) {
        Random random = new Random();
        if (random.nextGaussian() > (double)this.shield) {
            super.damaged(damageTaken);
        } else {
            System.out.println(this.name + " blocked");
        }

    }
}
