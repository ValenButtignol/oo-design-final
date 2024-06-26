package adventuregame.factory;

import adventuregame.character.AdventureCharacter;
import adventuregame.character.Dwarf;
import adventuregame.character.Gladiator;
import adventuregame.character.Knight;
import adventuregame.character.Orc;
import adventuregame.character.Troll;
import adventuregame.character.Wizard;
import adventuregame.weapon.Axe;
import adventuregame.weapon.BareFist;
import adventuregame.weapon.Bow;
import adventuregame.weapon.Hammer;
import adventuregame.weapon.LongSword;
import adventuregame.weapon.ShortSword;
import adventuregame.weapon.Staff;
import adventuregame.weapon.Wand;
import adventuregame.weapon.Weapon;
import adventuregame.weapon.gem.AmethystGem;
import adventuregame.weapon.gem.BlueGem;
import adventuregame.weapon.gem.GreenGem;
import adventuregame.weapon.gem.RedGem;
import adventuregame.weapon.gem.SapphireGem;
import adventuregame.weapon.gem.TopazGem;

public class MixedVersionFactory implements CharactersAndWeaponFactory {
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
        } else if (characterType.equals("orc")) {
            return new Orc(weapon);
        } else if (characterType.equals("dwarf")) {
            return new Dwarf(weapon);
        } else if (characterType.equals("troll")) {
            return new Troll(weapon);
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
        } else if (weaponType.equals("axe")) {
            return new Axe();
        } else if (weaponType.equals("hammer")) {
            return new Hammer();
        } else if (weaponType.equals("bow")) {
            return new Bow();
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
        } else if (gemType.equals("topaz")) {
            return new TopazGem(weapon);
        } else if (gemType.equals("sapphire")) {
            return new SapphireGem(weapon);
        } else if (gemType.equals("amethyst")) {
            return new AmethystGem(weapon);
        } else {
            throw new IllegalArgumentException("Invalid gem type");
        }
    }
}