package BatelArena;

import Fighters.*;
import Healers.Healer;
import error.FighterCantAttackException;

public class DuelArena extends BatelArena{
    private ArenaFighters participant1;
    private ArenaFighters participant2;

    public DuelArena(Healer healer, ArenaFighters participant1, ArenaFighters participant2) {
        super(healer);
        this.participant1 = participant1;
        this.participant2 = participant2;
    }

    @Override
    public void startBattle(int numberRounds) {
           try {
               confrontation(participant1, participant2, numberRounds);
           } catch (FighterCantAttackException e) {
               System.out.println("exception");
              printWinner();
           }
    }

    @Override
    public void printWinner() {
            System.out.println("In a duel 1 on 1  wins " + calculationOfWinner().getName() + " WIN!");
    }
}
