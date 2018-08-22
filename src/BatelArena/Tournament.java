package BatelArena;

import Fighters.*;
import Healers.Healer;
import error.FighterCantAttackException;


public class Tournament extends BatelArena {
    private ArenaFighters tournamentWinner;
    private ArenaFighters[] participants;

    public Tournament(Healer healer, ArenaFighters participant1, ArenaFighters participant2, ArenaFighters participant3,
                      ArenaFighters participant4, ArenaFighters participant5, ArenaFighters participant6,
                      ArenaFighters participant7, ArenaFighters participant8) {
        super(healer);
        participants = new ArenaFighters[]{participant1, participant2, participant3, participant4, participant5,
                participant6, participant7, participant8};
    }

    public int getNumberOfParticipants() {
        return participants.length;
    }

    @Override
    public void startBattle(int numberRounds) {
        tournamentWinner = battleInTournament(numberRounds, participants);
    }

    @Override
    public void printWinner() {
        if (tournamentWinner != null) {
            System.out.println("The winner of the tournament of " + getNumberOfParticipants() +
                    " participants becomes " + tournamentWinner.getName());
        }
    }

    private ArenaFighters battleInTournament(int numberRounds, ArenaFighters[] participants) {
        int index = 0;
        if (participants.length > 1) {
            ArenaFighters[] winners = new ArenaFighters[participants.length / 2];
            for (int i = 1; i < participants.length; i++) {
                if (i % 2 == 0) {
                    continue;
                }
                try {
                    confrontation(participants[i-1], participants[i], numberRounds);
                }
                catch (FighterCantAttackException e){
                    System.out.println("exception");
                }
                finally {
                    ArenaFighters win = calculationOfWinner();
                    winners[index++] = win;
                    System.out.println("<<<" + participants[i-1].getName() + " VS " + participants[i].getName() + ">>>" +
                            " WINS " + win.getName() );
                }
            }
            battleInTournament(numberRounds, winners);
        }
        return participants[0];
    }
}
