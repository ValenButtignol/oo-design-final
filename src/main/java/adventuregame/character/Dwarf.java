package adventuregame.character;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class Dwarf extends AdventureCharacter {
    
    public Dwarf() {
        super();
        hp = Constants.DWARF_HP;
        fightStyle = FightStyle.MELEE;
    }

    public Dwarf(Weapon weapon) {
        hp = Constants.DWARF_HP;
        fightStyle = FightStyle.MELEE;
        setWeapon(weapon);
    }

    @Override
    public String toString() {
        return "Dwarf";
    }

    @Override
    public int hashCode() {
        return Constants.DWARF_HP + weapon.hashCode();
    }
}
