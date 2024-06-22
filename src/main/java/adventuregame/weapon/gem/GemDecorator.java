package adventuregame.weapon.gem;

import adventuregame.weapon.Weapon;

public abstract class GemDecorator extends Weapon {
    
    protected Weapon weapon;

    public GemDecorator(Weapon weapon) {
        if (weapon.getGems() == weapon.getMaxGems())
            throw new IllegalArgumentException("No more stacking of gems is allowed");
        
        this.weapon = weapon;
    }

    public abstract Integer getDamage();

    public abstract Integer getGems();

    public Integer getMaxGems() {
        return weapon.getMaxGems();
    }
}