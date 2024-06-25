package adventuregame.character;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class Knight extends AdventureCharacter {
    
    public Knight() {
        super();
        hp = Constants.KNIGHT_HP;
        fightStyle = FightStyle.MELEE;
    }

    public Knight(Weapon weapon) {
        hp = Constants.KNIGHT_HP;
        fightStyle = FightStyle.MELEE;
        setWeapon(weapon);
    }

    @Override
    public String toString() {
        return "Knight";
    }

    @Override
    public int hashCode() {
        return Constants.KNIGHT_HP + weapon.hashCode();
    }
}