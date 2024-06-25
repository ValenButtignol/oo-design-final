package adventuregame.weapon.gem;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class BlueGem extends GemDecorator {
    
    public BlueGem(Weapon weapon) {
        super(weapon);
        this.damage = Constants.BLUE_GEM_DAMAGE + weapon.getDamage();
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
        return weapon.toString() + ", Blue Gem";
    }
}