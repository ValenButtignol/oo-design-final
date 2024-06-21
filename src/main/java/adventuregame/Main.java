package adventuregame;

import adventuregame.character.Knight;
import adventuregame.character.Wizard;
import adventuregame.displays.DisplayElement;
import adventuregame.displays.TerminalDisplayElement;
import adventuregame.observer.StatsObserver;
import adventuregame.weapon.LongSword;
import adventuregame.weapon.Wand;

public class Main {
    public static void main(String[] args) {
        BattleArena battleArena = new BattleArena(new Knight(new LongSword()), new Wizard(new Wand()));
        DisplayElement displayElement = new TerminalDisplayElement();
        StatsObserver statsObserver = new StatsObserver(battleArena, displayElement);
        battleArena.fight();
        System.out.println("\n");
        battleArena.setCharacters(new Knight(new LongSword()), new Wizard());
        battleArena.fight();
    }
}
