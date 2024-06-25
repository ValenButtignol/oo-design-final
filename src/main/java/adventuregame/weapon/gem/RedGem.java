package adventuregame.weapon.gem;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class RedGem extends GemDecorator {
    
    public RedGem(Weapon weapon) {
        super(weapon);
        this.damage = Constants.RED_GEM_DAMAGE + weapon.getDamage();
        this.fightStyle = weapon.getFightStyle();
    }

    public Integer getDamage() {
        return damage;
    }

    public Integer getGems() {
        return 1 + weapon.getGems();
    }

    public FightStyle getFightStyle() {
        return fightStyle;
    }

    public String toString() {
        return weapon.toString() + ", Red Gem";
    }
}   