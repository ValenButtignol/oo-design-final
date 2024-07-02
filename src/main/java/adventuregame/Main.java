package adventuregame;

import java.util.List;

import adventuregame.factory.CharactersAndWeaponFactory;
import adventuregame.factory.HumanVersionFactory;

public class Main {
    public static void main(String[] args) {
        CharactersAndWeaponFactory factory = new HumanVersionFactory();
        BattleController client = new BattleController(factory);

        client.createCharacterWithWeapon("wizard", "staff", List.of());
        client.createCharacterWithWeapon("knight", "bare fist", List.of());
        client.createCharacterWithWeapon("gladiator", "long sword", List.of("red"));
        client.createCharacterWithWeapon("wizard", "wand", List.of("red"));
        client.createCharacterWithWeapon("wizard", "wand", List.of("red", "green"));
        client.createCharacterWithWeapon("wizard", "wand", List.of("blue"));

        client.fight(0, 1);
        client.fight(2,3);
        client.fight(3, 4);
    }
}