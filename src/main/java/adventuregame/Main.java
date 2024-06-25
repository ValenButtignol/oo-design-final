package adventuregame;

import adventuregame.character.AdventureCharacter;
import adventuregame.displays.DisplayElement;
import adventuregame.displays.TerminalDisplayElement;
import adventuregame.factory.HumanVersionFactory;
import adventuregame.factory.CharactersAndWeaponFactory;
import adventuregame.observer.StatsObserver;
import adventuregame.weapon.Weapon;

public class Main {
    public static void main(String[] args) {
        CharactersAndWeaponFactory factory = new HumanVersionFactory();
        
        Weapon staff = factory.createWeapon("staff");
        AdventureCharacter c1 = factory.createCharacter("wizard", staff);
        
        Weapon barefist = factory.createWeapon("bare fist");
        AdventureCharacter c2 = factory.createCharacter("knight", barefist);
        
        BattleArena battleArena = new BattleArena(c1, c2);
        DisplayElement displayElement = new TerminalDisplayElement();
        StatsObserver statsObserver = new StatsObserver(battleArena, displayElement);
        battleArena.fight();
        System.out.println("\n");
        
        Weapon w1 = factory.createWeapon("wand");
        w1 = factory.addGem(w1, "red");
        battleArena.setCharacters(factory.createCharacter("wizard", w1), factory.createCharacter("knight", barefist));
        battleArena.fight();
        System.out.println("\n");
        
        battleArena.setCharacters(factory.createCharacter("wizard", w1), factory.createCharacter("knight", barefist));
        battleArena.fight();
        System.out.println("\n");

        Weapon w2 = factory.createWeapon("wand");
        w2 = factory.addGem(w2, "green");
        w2 = factory.addGem(w2, "green");
        battleArena.setCharacters(factory.createCharacter("wizard", w2), factory.createCharacter("knight", barefist));
        battleArena.fight();
        System.out.println("\n");

        Weapon w3 = factory.createWeapon("wand");
        w3 = factory.addGem(w3, "blue");
        battleArena.setCharacters(factory.createCharacter("wizard", w3), factory.createCharacter("knight", barefist));
        battleArena.fight();
        System.out.println("\n");
    }
}
