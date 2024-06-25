package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class Axe extends Weapon {
    private final Integer MAX_GEMS = 3;

    public Axe() {
        damage = Constants.AXE_DAMAGE;
        fightStyle = FightStyle.MELEE;
    }

    public String toString() {
        return "Axe";
    }

    public Integer getMaxGems() {
        return MAX_GEMS;
    }
}