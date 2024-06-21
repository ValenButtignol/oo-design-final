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

    @Override
    public boolean equals(Object otherWeapon) {
        if (this == otherWeapon) {
            return true;
        }
        
        if (getClass() != otherWeapon.getClass()) {
            return false;
        }

        Weapon other = (Weapon) otherWeapon;
        return damage.equals(other.damage) && fightStyle.equals(other.fightStyle);
    }

    @Override
    public int hashCode() {
        return damage;
    }
}