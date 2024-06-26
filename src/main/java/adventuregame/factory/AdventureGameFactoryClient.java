package adventuregame.factory;

import java.util.List;

import adventuregame.character.AdventureCharacter;
import adventuregame.weapon.Weapon;

public class AdventureGameFactoryClient {
    private CharactersAndWeaponFactory factory;

    public AdventureGameFactoryClient(CharactersAndWeaponFactory factory) {
        this.factory = factory;
    }

    public AdventureCharacter createCharacterWithWeapon(String characterType, String weaponType) {
        Weapon weapon = factory.createWeapon(weaponType);

        AdventureCharacter character = factory.createCharacter(characterType, weapon);
        return character;
    }

    public AdventureCharacter createCharacterWithWeapon(String characterType, String weaponType, List<String> gems) {
        Weapon weapon = factory.createWeapon(weaponType);
        for (String gem : gems) {
           weapon = factory.addGem(weapon, gem);
        }

        AdventureCharacter character = factory.createCharacter(characterType, weapon);
        return character;
    }
}
