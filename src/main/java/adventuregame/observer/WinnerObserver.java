package adventuregame.observer;

import adventuregame.Subject;
import adventuregame.character.AdventureCharacter;
import adventuregame.displays.DisplayElement;

public class WinnerObserver implements Observer {
 
    private Subject battleArena;
    private AdventureCharacter winner;
    private AdventureCharacter loser;
    private DisplayElement displayElement;

    public WinnerObserver(Subject battleArena, DisplayElement displayElement) {
        this.battleArena = battleArena;
        battleArena.registerObserver(this);
        this.displayElement = displayElement;
    }

    @Override
    public void updateStart(AdventureCharacter character1, AdventureCharacter character2) {
    }

    @Override
    public void updateAttack(AdventureCharacter attacker, AdventureCharacter target) {
    }

    @Override
    public void updateWinner(AdventureCharacter winner, AdventureCharacter loser) {
        this.winner = winner;
        this.loser = loser;
        sendDisplayMessage();
    }

    private void sendDisplayMessage() {
        displayElement.display(loser.toString() + " has been defeated!");
        displayElement.display(winner.toString() + " Winner Winner Chicken Dinner!");
    }
}
