package adventuregame.observer;

import adventuregame.BattleArena;
import adventuregame.character.AdventureCharacter;
import adventuregame.displays.DisplayElement;

public class BattleEndObserver implements Observer {
 
    private BattleArena battleArena;
    private AdventureCharacter winner;
    private DisplayElement displayElement;

    public BattleEndObserver(BattleArena battleArena, DisplayElement displayElement) {
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
    public void updateWinner(AdventureCharacter winner) {
        this.winner = winner;
        sendDisplayMessage();
    }

    private void sendDisplayMessage() {
        displayElement.display(winner.toString() + " Winner Winner Chicken Dinner!");
    }
}
