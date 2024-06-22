package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class Wand extends Weapon {
    
    private final Integer MAX_GEMS = 3;

    public Wand() {
        damage = Constants.WAND_DAMAGE;
        fightStyle = FightStyle.MAGE;
    }

    public String toString() {
        return "Wand";
    }

    public Integer getMaxGems() {
        return MAX_GEMS;
    }
}