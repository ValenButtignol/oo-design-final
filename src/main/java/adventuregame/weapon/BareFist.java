package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class BareFist extends Weapon {
    public BareFist() {
        damage = Constants.BARE_FIST_DAMAGE;
        fightStyle = FightStyle.DEFAULT;
    }

    @Override
    public String toString() {
        return "Bare Fist";
    }
}