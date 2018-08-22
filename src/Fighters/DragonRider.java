package Fighters;

import error.FighterCantAttackException;

public class DragonRider extends ArenaFighters implements CanAtackDragon{
    private Dragon ridingDragon;
    private float healthDragon;

    public DragonRider(String name, float health, float damage, float armor) {
        super(name, health, damage, armor);
    }

    @Override
    public void attack(ArenaFighters var1) {

        if (var1 instanceof Dragon) {
            attackDragon((Dragon) var1);
        } else {
            var1.damaged(this.damage);
        }
    }

    public void attackDragon(Dragon dragon) {
        this.ridingDragon = dragon;
        healthDragon = dragon.getHealth();
        dragon.setHealth(0);
    }
}
