package adventuregame.character;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class Orc extends AdventureCharacter {
    
    public Orc() {
        super();
        setHp(Constants.ORC_HP);
        fightStyle = FightStyle.RANGED;
    }

    public Orc(Weapon weapon) {
        setHp(Constants.ORC_HP);
        fightStyle = FightStyle.RANGED;
        setWeapon(weapon);
    }

    @Override
    public String toString() {
        return "Orc";
    }

    @Override
    public int hashCode() {
        return initHp + weapon.hashCode();
    }
}
