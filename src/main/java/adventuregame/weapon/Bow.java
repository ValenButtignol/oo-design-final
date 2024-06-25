package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class Bow extends Weapon {
    private final Integer MAX_GEMS = 2;

    public Bow() {
        damage = Constants.BOW_DAMAGE;
        fightStyle = FightStyle.RANGED;
    }

    public String toString() {
        return "Bow";
    }

    public Integer getMaxGems() {
        return MAX_GEMS;
    }    
}