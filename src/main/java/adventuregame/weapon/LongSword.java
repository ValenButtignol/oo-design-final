package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class LongSword extends Weapon {

    private final Integer MAX_GEMS = 1;

    public LongSword() {
        damage = Constants.LONG_SWORD_DAMAGE;
        fightStyle = FightStyle.MELEE;
    }

    public String toString() {
        return "Long Sword";
    }

    public Integer getMaxGems() {
        return MAX_GEMS;
    }
}