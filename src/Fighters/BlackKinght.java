package Fighters;

public class BlackKinght extends Knight{
    public BlackKinght(String name, float health, float damage, float armor, float shield) {
        super(name, health, damage, armor, shield);
    }

    private void recovery(float damageTaken) {
        if (this.isAlfie()) {
            float recovery =damageTaken / 2;
            this.heal(recovery);
            System.out.println(this.getName() + " recovery " + recovery);
        }
    }

    @Override
    protected void damaged(float damageTaken) {
        super.damaged(damageTaken);
        recovery(damageTaken);
    }
}
