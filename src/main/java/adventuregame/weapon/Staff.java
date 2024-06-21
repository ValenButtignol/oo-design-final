package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class Staff extends Weapon {
    
    public Staff() {
        damage = Constants.STAFF_DAMAGE;
        fightStyle = FightStyle.MAGE;
    }

    @Override
    public String toString() {
        return "Staff";
    }
}