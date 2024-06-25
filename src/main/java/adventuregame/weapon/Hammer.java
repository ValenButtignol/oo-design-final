package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class Hammer extends Weapon {
    private final Integer MAX_GEMS = 2;

    public Hammer() {
        damage = Constants.HAMMER_DAMAGE;
        fightStyle = FightStyle.MELEE;
    }

    public String toString() {
        return "Hammer";
    }

    public Integer getMaxGems() {
        return MAX_GEMS;
    }
}
