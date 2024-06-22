package adventuregame.weapon.gem;

import adventuregame.weapon.Weapon;

public class BlueGem extends GemDecorator {
    
    public BlueGem(Weapon weapon) {
        super(weapon);
    }

    public Integer getDamage() {
        return 30 + weapon.getDamage();
    }

    public Integer getGems() {
        return 1 + weapon.getGems();
    }
}