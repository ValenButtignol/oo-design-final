package adventuregame.observer;

import adventuregame.BattleArena;
import adventuregame.character.AdventureCharacter;
import adventuregame.displays.DisplayElement;
import adventuregame.weapon.Weapon;

public class AttackObserver implements Observer {

    private BattleArena battleArena;
    private AdventureCharacter attacker;
    private AdventureCharacter target;
    private DisplayElement displayElement;

    public AttackObserver(BattleArena battleArena, DisplayElement displayElement) {
        this.battleArena = battleArena;
        battleArena.registerObserver(this);
        this.displayElement = displayElement;
    }

    @Override
    public void updateStart(AdventureCharacter character1, AdventureCharacter character2) {
    }

    @Override
    public void updateAttack(AdventureCharacter attacker, AdventureCharacter target) {
        this.attacker = attacker;
        this.target = target;
        sendDisplayMessage();
    }

    @Override
    public void updateWinner(AdventureCharacter winner) {
    }

    private void sendDisplayMessage() {
        Weapon weapon1 = attacker.getWeapon();

        displayElement.display(attacker.toString() + " attacks " + target.toString() + 
            " with " + weapon1.toString() + "!");
        displayElement.display("- " + attacker.toString() + " deals " + weapon1.getDamage() + " damage");
        displayElement.display("- " + target.toString() + " has " + target.getHp() + " health left!");

        if (target.getHp() <= 0) {
            displayElement.display(target.toString() + " has been defeated!");
        }
    }
}