package adventuregame.weapon.gem;

import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class RedGem extends GemDecorator {
    
    public RedGem(Weapon weapon) {
        super(weapon);
    }

    public Integer getDamage() {
        return 50 + weapon.getDamage();
    }

    public Integer getGems() {
        return 1 + weapon.getGems();
    }

    public FightStyle getFightStyle() {
        return weapon.getFightStyle();
    }
}   