package adventuregame.factory;

import adventuregame.character.AdventureCharacter;
import adventuregame.character.Dwarf;
import adventuregame.character.Orc;
import adventuregame.character.Troll;
import adventuregame.weapon.Axe;
import adventuregame.weapon.BareFist;
import adventuregame.weapon.Bow;
import adventuregame.weapon.Hammer;
import adventuregame.weapon.Weapon;
import adventuregame.weapon.gem.AmethystGem;
import adventuregame.weapon.gem.SapphireGem;
import adventuregame.weapon.gem.TopazGem;

public class MonsterVersionFactory implements CharactersAndWeaponFactory {

    @Override
    public AdventureCharacter createCharacter(String characterType, Weapon weapon) {
        if (characterType == null) {
            throw new IllegalArgumentException("Character type cannot be null");
        }

        if (characterType.equals("dwarf")) {
            return new Dwarf(weapon);
        } else if (characterType.equals("orc")) {
            return new Orc(weapon);
        } else if (characterType.equals("troll")) {
            return new Troll(weapon);
        } else {
            throw new IllegalArgumentException("Invalid character type");
        }
    }

    @Override
    public Weapon createWeapon(String weaponType) {
        if (weaponType == null) {
            throw new IllegalArgumentException("Weapon type cannot be null");
        }

        if (weaponType.equals("bow")) {
            return new Bow();
        } else if (weaponType.equals("axe")) {
            return new Axe();
        } else if (weaponType.equals("hammer")) {
            return new Hammer();
        } else if (weaponType.equals("bare fist")) {
            return new BareFist();
        } else {
            throw new IllegalArgumentException("Invalid weapon type");
        }   
    }

    @Override
    public Weapon addGem(Weapon weapon, String gemType) {
        if (weapon == null) 
            throw new IllegalArgumentException("Weapon cannot be null");
        if (gemType == null) 
            throw new IllegalArgumentException("Gem type cannot be null");

        if (gemType.equals("amethyst")) {
            return new AmethystGem(weapon);
        } else if (gemType.equals("topaz")) {
            return new TopazGem(weapon);
        } else if (gemType.equals("sapphire")) {
            return new SapphireGem(weapon);
        }

        return weapon;
    }
}
