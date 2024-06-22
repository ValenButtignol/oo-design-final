package adventuregame.weapon.gem;

import adventuregame.weapon.Weapon;

public class GreenGem extends GemDecorator {
    
    public GreenGem(Weapon weapon) {
        super(weapon);
    }

    public Integer getDamage() {
        return 15 + weapon.getDamage();
    }

    public Integer getGems() {
        return 1 + weapon.getGems();
    }
}