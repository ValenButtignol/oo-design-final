package adventuregame.factory;

import adventuregame.character.AdventureCharacter;
import adventuregame.weapon.Weapon;

public interface CharactersAndWeaponFactory {
    public AdventureCharacter createCharacter(String characterType, Weapon weapon);
    public Weapon createWeapon(String weaponType);
    public Weapon addGem(Weapon weapon, String gemType);
}