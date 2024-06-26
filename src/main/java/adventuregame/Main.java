package adventuregame;

import java.util.List;

import adventuregame.character.AdventureCharacter;
import adventuregame.displays.DisplayElement;
import adventuregame.displays.TerminalDisplayElement;
import adventuregame.factory.CharactersAndWeaponFactory;
import adventuregame.factory.AdventureGameFactoryClient;
import adventuregame.factory.HumanVersionFactory;
import adventuregame.observer.StatsObserver;

public class Main {
    public static void main(String[] args) {
        CharactersAndWeaponFactory factory = new HumanVersionFactory();
        AdventureGameFactoryClient client = new AdventureGameFactoryClient(factory);

        AdventureCharacter c1 = client.createCharacterWithWeapon("wizard", "staff");
        AdventureCharacter c2 = client.createCharacterWithWeapon("knight", "bare fist");
        BattleArena battleArena = new BattleArena(c1, c2);
        
        DisplayElement displayElement = new TerminalDisplayElement();
        StatsObserver statsObserver = new StatsObserver(battleArena, displayElement);
        
        battleArena.fight();
        System.out.println("\n");
        
        c1 = client.createCharacterWithWeapon("wizard", "wand", List.of("red"));
        battleArena.setCharacters(c1, c2);
        System.out.println("\n");
        battleArena.fight();
        System.out.println("\n");
         
        battleArena.setCharacters(c1, c2);
        battleArena.fight();
        System.out.println("\n");
        
        c1 = client.createCharacterWithWeapon("wizard", "wand", List.of("green", "green"));
        battleArena.setCharacters(c1, c2);
        battleArena.fight();
        System.out.println("\n");
        
        c1 = client.createCharacterWithWeapon("wizard", "wand", List.of("blue"));
        battleArena.setCharacters(c1, c2);
        battleArena.fight();
        System.out.println("\n");
    }
}