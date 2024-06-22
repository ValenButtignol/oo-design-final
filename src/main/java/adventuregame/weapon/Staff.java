package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class Staff extends Weapon {
    
    private final Integer MAX_GEMS = 2;

    public Staff() {
        damage = Constants.STAFF_DAMAGE;
        fightStyle = FightStyle.MAGE;
    }

    @Override
    public String toString() {
        return "Staff";
    }

    public Integer getMaxGems() {
        return MAX_GEMS;
    }
}