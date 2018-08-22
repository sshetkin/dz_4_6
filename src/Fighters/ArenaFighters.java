package Fighters;

import error.FighterCantAttackException;

public abstract class ArenaFighters {
    protected String name;
    protected float health;
    protected float damage;
    protected float armor;
    protected float maxHealth;

    public ArenaFighters(String name, float health, float damage, float armor) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.maxHealth = health;
    }

    public boolean isAlfie() {
        return health > 0;
    }

    public String getName() {
        return this.name;
    }

    public void heal(float health) {
        float newHeal = this.health + health;
        this.health = Math.min(newHeal, this.maxHealth);
    }

    public abstract void attack(ArenaFighters var1);

    protected void damaged(float damageTaken) {
        float resist = (damageTaken * armor);
        float gotDamage = damageTaken - resist;
        health -= gotDamage;
        System.out.println(name + " got damage\t" + gotDamage + " resisted "
                + resist + " health left " + health);
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }
}
