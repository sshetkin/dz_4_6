import BatelArena.*;
import Fighters.*;
import Healers.Healer;

public class Main {
    public static void main (String[] args){
        Healer healer = new Healer("Jorge", 5);

        Dragon freddy = new Dragon("Freddy",350, 14, 0.5f, Dragon.EARTH|Dragon.FIRE);
        Dragon chuck = new Dragon("Chuck",300, 15, 0.3f, Dragon.WATER|Dragon.WIND);
        Dragon bobby = new Dragon("Bobby",400, 10, 0.4f, Dragon.EARTH|Dragon.WIND);
        Dragon michael = new Dragon("Michael",400, 10, 0.4f, Dragon.EARTH|Dragon.WIND);
        DragonRider dragonRider = new DragonRider("DragonRider", 100, 10, 5);
        Knight knight = new Knight("Knight", 100, 40.0f, 0.5f, 1);
        ArenaFighters hollyKnight = new HollyKnight("HollyKnight", 100, 15, 0.15f, 2, 5);
        ArenaFighters blackKnight = new BlackKinght("BlackKnight",150, 40, 0.5f, 1);

        DuelArena duelArena = new DuelArena(healer, freddy, dragonRider);
        Tournament tournament = new Tournament(healer, bobby, dragonRider, hollyKnight, blackKnight, freddy, chuck,
                knight, michael);

        /*duelArena.startBattle(10);
        duelArena.printWinner();*/

        tournament.startBattle(10);
        tournament.printWinner();
    }
}
