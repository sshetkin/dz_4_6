package BatelArena;

import Healers.Healer;
import Fighters.*;
import error.FighterCantAttackException;


public abstract class BatelArena {
    private Healer healer;
    private ArenaFighters participant1;
    private ArenaFighters participant2;

    public BatelArena(Healer healer) {
        this.healer = healer;
    }

    public abstract void startBattle(int numberRounds);

    public abstract void printWinner();

    protected void confrontation(ArenaFighters participant1, ArenaFighters participant2, int numberRounds) throws FighterCantAttackException{
        this.participant1 = participant1;
        this.participant2 = participant2;
        for (int i = 0; i < numberRounds; i++) {
            if (isFightContinue()) {
                    participant1.attack(participant2);
                    if (participant2.getHealth() <= 0) {
                        throw new FighterCantAttackException();
                    }
                    participant2.attack(participant1);
                    healer.heal(dropTheCoin() ? participant1 : participant2);

            }
        }
    }

    protected ArenaFighters calculationOfWinner() {
        if (participant1 != null || participant2 != null) {
            if (participant1.isAlfie() && participant2.isAlfie()) {
                return (participant1.getHealth() > participant2.getHealth()) ? participant1 : participant2;
            } else if (this.participant1.isAlfie()) {
                return participant1;
            } else if (this.participant2.isAlfie()) {
                return participant2;
            }
        }
        return null;
    }

    private boolean dropTheCoin() {
        int randomNum = (int)(Math.random() * 100);
        return (randomNum % 2) == 0;
    }

    private boolean isFightContinue() {
        return participant1.isAlfie() && participant2.isAlfie();
    }
}
