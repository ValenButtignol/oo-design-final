package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class ShortSword extends Weapon {

    private final Integer MAX_GEMS = 4;
    
    public ShortSword() {
        damage = Constants.SHORT_SWORD_DAMAGE;
        fightStyle = FightStyle.MELEE;
    }

    public String toString() {
        return "Short Sword";
    }

    public Integer getMaxGems() {
        return MAX_GEMS;
    }
}