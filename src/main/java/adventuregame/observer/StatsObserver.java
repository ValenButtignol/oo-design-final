package adventuregame.observer;

import java.util.HashMap;

import adventuregame.BattleArena;
import adventuregame.character.AdventureCharacter;
import adventuregame.displays.DisplayElement;

public class StatsObserver implements Observer {

    private BattleArena battleArena;
    private DisplayElement displayElement;
    private HashMap<AdventureCharacter, Integer> winsCount;

    public StatsObserver(BattleArena battleArena, DisplayElement displayElement) {
        this.battleArena = battleArena;
        battleArena.registerObserver(this);
        this.displayElement = displayElement;
        winsCount = new HashMap<>();
    }

    @Override
    public void updateAttack(AdventureCharacter attacker, AdventureCharacter target) { }

    @Override
    public void updateStart(AdventureCharacter character1, AdventureCharacter character2) { }

    @Override
    public void updateWinner(AdventureCharacter winner) {
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
            displayElement.display(character.toString() + " with " + character.getWeapon().toString() + ": " + winsCount.get(character));
        }
    }
}