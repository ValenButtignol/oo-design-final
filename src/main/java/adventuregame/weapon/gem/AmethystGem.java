package adventuregame.weapon.gem;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class AmethystGem extends GemDecorator {

    public AmethystGem(Weapon weapon) {
        super(weapon);
        this.damage = Constants.AMETHYST_GEM_DAMAGE + weapon.getDamage();
        this.fightStyle = weapon.getFightStyle();
    }

    @Override
    public Integer getDamage() {
        return damage;
    }

    @Override
    public Integer getGems() {
        return 1 + weapon.getGems();
    }

    @Override
    public FightStyle getFightStyle() {
        return fightStyle;
    }
        
    public String toString() {
        return weapon.toString() + " Amethyst Gem";
    }   
}