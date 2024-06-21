package adventuregame.observer;

import adventuregame.Subject;
import adventuregame.character.AdventureCharacter;
import adventuregame.displays.DisplayElement;
import adventuregame.weapon.Weapon;

public class BattleStartObserver implements Observer {

    private Subject battleArena;
    private AdventureCharacter character1;
    private AdventureCharacter character2;
    private DisplayElement displayElement;

    public BattleStartObserver(Subject battleArena, DisplayElement displayElement) {
        this.battleArena = battleArena;
        battleArena.registerObserver(this);
        this.displayElement = displayElement;
    }

    @Override
    public void updateStart(AdventureCharacter character1, AdventureCharacter character2) {
        this.character1 = character1;
        this.character2 = character2;
        sendDisplayMessage();
    }

    @Override
    public void updateAttack(AdventureCharacter attacker, AdventureCharacter target) {
    }

    @Override
    public void updateWinner(AdventureCharacter winner, AdventureCharacter loser) {
    }

    private void sendDisplayMessage() {
        Weapon weapon1 = character1.getWeapon();
        Weapon weapon2 = character2.getWeapon();

        displayElement.display("Battle between " + character1.toString() + " with " + weapon1.toString() + " vs "
            + character2.toString() + "with" + weapon2.toString() + " has started!");
    }

}