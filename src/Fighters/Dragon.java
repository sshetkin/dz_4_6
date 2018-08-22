package Fighters;

public class Dragon extends ArenaFighters implements CanAtackDragon{
    public static int FIRE = 2;
    public static int WATER = 4;
    public static int EARTH = 8;
    public static int WIND = 16;

    int params;

    public Dragon(String name, float health, float damage, float armor, int params) {
        super(name, health, damage, armor);
        this.params = params;
    }

    public void attackDragon(Dragon dragon) {
        float damageTaken = 0f;
        int degreeCritDamage = 3;
        float superDamage = calculationChanceCritDamage(this.damage, degreeCritDamage);
        if ((params & FIRE) == FIRE && (dragon.params & WATER) == WATER) {
            damageTaken += superDamage * 2;
        }else damageTaken += superDamage;
        if ((params & WATER) == WATER && (dragon.params & EARTH) == EARTH) {
            damageTaken += superDamage * 2;
        }else damageTaken += superDamage;
        if ((params & EARTH) == EARTH && (dragon.params & WIND) == WIND) {
            damageTaken += superDamage * 2;
        }else damageTaken += superDamage;
        if ((params & WIND) == WIND && (dragon.params & FIRE) == FIRE) {
            damageTaken += superDamage * 2;
        }else damageTaken += superDamage;

        dragon.damaged(damageTaken);
    }

    private float calculationChanceCritDamage(float damage, int degreeCritDamage) {
        int randomNum = (int)(Math.random()*10) + 1;
        if (randomNum == 10) {
            return (float)Math.pow(damage, degreeCritDamage);
        }
        return damage;
    }

    @Override
    public void attack(ArenaFighters var1) {
        if (var1 instanceof Dragon) {
            attackDragon((Dragon)var1);
        } //else if (!(var1 instanceof DragonRider)) {
            else {
            var1.damaged(this.damage);
        }

    }
}
