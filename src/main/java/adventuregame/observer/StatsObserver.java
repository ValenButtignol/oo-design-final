package adventuregame.observer;

import java.util.HashMap;

import adventuregame.Subject;
import adventuregame.character.AdventureCharacter;
import adventuregame.displays.DisplayElement;

public class StatsObserver implements Observer {

    private Subject battleArena;
    private AdventureCharacter character1;
    private DisplayElement displayElement;
    private HashMap<AdventureCharacter, Integer> winsCount;

    public StatsObserver(Subject battleArena, DisplayElement displayElement) {
        this.battleArena = battleArena;
        battleArena.registerObserver(this);
        this.displayElement = displayElement;
        winsCount = new HashMap<>();
    }

    @Override
    public void updateAttack(AdventureCharacter attacker, AdventureCharacter target) {
    }

    @Override
    public void updateStart(AdventureCharacter character1, AdventureCharacter character2) {
    }

    @Override
    public void updateWinner(AdventureCharacter winner, AdventureCharacter loser) {
        if (winsCount.containsKey(winner)) {
            winsCount.put(winner, winsCount.get(winner) + 1);
        } else {
            winsCount.put(winner, 1);
        }
        sendDisplayMessage();
    }

    private void sendDisplayMessage() {
        displayElement.display("Wins count:");
        for (AdventureCharacter character : winsCount.keySet()) {
            displayElement.display(character.toString() + "\t" + character.getWeapon().toString() + "\t: " + winsCount.get(character));
        }
    }

}
