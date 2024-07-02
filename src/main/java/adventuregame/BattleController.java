package adventuregame;

import java.util.ArrayList;
import java.util.List;

import adventuregame.character.AdventureCharacter;
import adventuregame.displays.TerminalDisplayElement;
import adventuregame.factory.CharactersAndWeaponFactory;
import adventuregame.observer.AttackObserver;
import adventuregame.observer.BattleEndObserver;
import adventuregame.observer.BattleStartObserver;
import adventuregame.observer.Observer;
import adventuregame.observer.StatsObserver;
import adventuregame.weapon.Weapon;

public class BattleController {
    private CharactersAndWeaponFactory factory;
    private BattleArena battleArena;
    private List<AdventureCharacter> characters;

    public BattleController(CharactersAndWeaponFactory factory) {
        this.factory = factory;
        this.characters = new ArrayList<>();
        this.battleArena = new BattleArena();
        createObservers();
    }

    public BattleArena getBattleArena() {
        return battleArena;
    }
    
    private void createObservers() {
        Observer startObserver = new BattleStartObserver(battleArena, new TerminalDisplayElement());
        Observer attackObserver = new AttackObserver(battleArena, new TerminalDisplayElement());
        Observer endObserver = new BattleEndObserver(battleArena, new TerminalDisplayElement());
        Observer statsObserver = new StatsObserver(battleArena, new TerminalDisplayElement());
    }

    public AdventureCharacter createCharacterWithWeapon(String characterType, String weaponType, List<String> gems) {
        Weapon weapon = createWeapon(weaponType, gems);

        AdventureCharacter character = factory.createCharacter(characterType, weapon);
        characters.add(character);
        return character;
    }

    public void changeCharacterWeapon(int index, String weaponType, List<String> gems) {
        AdventureCharacter character = characters.get(index);
        Weapon weapon = createWeapon(weaponType, gems);
        character.setWeapon(weapon);
    }

    private Weapon createWeapon(String weaponType, List<String> gems) {
        Weapon weapon = factory.createWeapon(weaponType);
        for (String gem : gems) {
           weapon = factory.addGem(weapon, gem);
        }
        return weapon;
    }

    public void fight(int character1Index, int character2Index) {
        battleArena.setCharacters(characters.get(character1Index), characters.get(character2Index));
        battleArena.fight();
    }
}