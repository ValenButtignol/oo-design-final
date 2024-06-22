package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class BareFist extends Weapon {

    private final Integer MAX_GEMS = 0;

    public BareFist() {
        damage = Constants.BARE_FIST_DAMAGE;
        fightStyle = FightStyle.DEFAULT;
    }

    public String toString() {
        return "Bare Fists";
    }

    public Integer getMaxGems() {
        return MAX_GEMS;
    }
}