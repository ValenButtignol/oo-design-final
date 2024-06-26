package adventuregame.character;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class Knight extends AdventureCharacter {
    
    public Knight() {
        super();
        setHp(Constants.KNIGHT_HP);
        fightStyle = FightStyle.MELEE;
    }

    public Knight(Weapon weapon) {
        setHp(Constants.KNIGHT_HP);
        fightStyle = FightStyle.MELEE;
        setWeapon(weapon);
    }

    @Override
    public String toString() {
        return "Knight";
    }

    @Override
    public int hashCode() {
        return initHp + weapon.hashCode();
    }
}