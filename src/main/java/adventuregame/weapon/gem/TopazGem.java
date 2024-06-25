package adventuregame.weapon.gem;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class TopazGem extends GemDecorator {
        
    public TopazGem(Weapon weapon) {
        super(weapon);
        this.damage = Constants.TOPAZ_GEM_DAMAGE + weapon.getDamage();
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
        return weapon.toString() + " Topaz Gem";
    }
}
