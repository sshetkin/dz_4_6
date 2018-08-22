package Healers;

import Fighters.*;

public class Healer {
    private String name;
    private int heal;


    public Healer(String name, int heal) {
        this.heal = heal;
        this.name = name;
    }

    public void heal(ArenaFighters fighter) {
        if (fighter.isAlfie()) {
            fighter.heal((float)this.heal);
            System.out.println(this.name + " healing " + fighter.getName() + " " + this.heal);
        }

    }
}
