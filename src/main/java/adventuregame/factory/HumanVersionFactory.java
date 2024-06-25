package adventuregame.factory;

import adventuregame.character.AdventureCharacter;
import adventuregame.character.Gladiator;
import adventuregame.character.Knight;
import adventuregame.character.Wizard;
import adventuregame.weapon.BareFist;
import adventuregame.weapon.LongSword;
import adventuregame.weapon.ShortSword;
import adventuregame.weapon.Staff;
import adventuregame.weapon.Wand;
import adventuregame.weapon.Weapon;
import adventuregame.weapon.gem.BlueGem;
import adventuregame.weapon.gem.GreenGem;
import adventuregame.weapon.gem.RedGem;

public class HumanVersionFactory implements CharactersAndWeaponFactory {
    
    @Override
    public AdventureCharacter createCharacter(String characterType, Weapon weapon) {
        if (characterType == null) 
            throw new IllegalArgumentException("Character type cannot be null");
        if (weapon == null) 
            throw new IllegalArgumentException("Weapon cannot be null");

        if (characterType.equals("gladiator")) {
            return new Gladiator(weapon);
        } else if (characterType.equals("knight")) {
            return new Knight(weapon);
        } else if (characterType.equals("wizard")) {
            return new Wizard(weapon);
        } else {
            throw new IllegalArgumentException("Invalid character type");
        }
    }

    public Weapon createWeapon(String weaponType) {
        if (weaponType == null) {
            throw new IllegalArgumentException("Weapon type cannot be null");
        }

        if (weaponType.equals("wand")) {
            return new Wand();
        } else if (weaponType.equals("staff")) {
            return new Staff();
        } else if (weaponType.equals("short sword")) {
            return new ShortSword();
        } else if (weaponType.equals("long sword")) {
            return new LongSword();
        } else if (weaponType.equals("bare fist")) {
            return new BareFist();
        } else {
            throw new IllegalArgumentException("Invalid weapon type");
        }
    }

    public Weapon addGem(Weapon weapon, String gemType) {
        if (weapon == null) 
            throw new IllegalArgumentException("Weapon cannot be null");
        if (gemType == null) 
            throw new IllegalArgumentException("Gem type cannot be null");
        
        if (gemType.equals("red")) {
            return new RedGem(weapon);
        } else if (gemType.equals("blue")) {
            return new BlueGem(weapon);
        } else if (gemType.equals("green")) {
            return new GreenGem(weapon);
        }

        return weapon;
    }
}
