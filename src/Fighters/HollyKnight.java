package Fighters;

public class HollyKnight extends Knight{
    private float recovery;

    public HollyKnight(String name, float health, float damage, float armor, float shield, float recovery) {
        super(name, health, damage, armor, shield);
        this.recovery = recovery;
    }

    private void recovery(float damage) {
        if (this.isAlfie()) {
            this.heal(damage);
            System.out.println(this.getName() + " recovery " + recovery);
        }
    }

    @Override
    public void attack(ArenaFighters arenaFighter) {
        super.attack(arenaFighter);
        recovery(recovery);
    }
}
