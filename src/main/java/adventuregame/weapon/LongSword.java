package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class LongSword extends Weapon {

    public LongSword() {
        damage = Constants.LONG_SWORD_DAMAGE;
        fightStyle = FightStyle.MELEE;
    }

    @Override
    public String toString() {
        return "Long Sword";
    }
}