package adventuregame.weapon;

import adventuregame.FightStyle;

public abstract class Weapon {
    protected FightStyle fightStyle;
    protected Integer damage;

    public Integer getDamage() {
        return damage;
    }

    public FightStyle getFightStyle() {
        return fightStyle;
    }
}