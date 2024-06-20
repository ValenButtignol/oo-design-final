package adventuregame.character;

import adventuregame.FightStyle;
import adventuregame.weapon.BareFist;
import adventuregame.weapon.Weapon;

public abstract class AdventureCharacter {
    protected Weapon weapon;
    protected Integer hp;
    protected FightStyle fightStyle;

    public AdventureCharacter() {
        weapon = new BareFist();
    }

    public void setWeapon(Weapon weapon) {
        if (weapon.getFightStyle() != fightStyle)
            throw new IllegalArgumentException("Weapon's fight style not compatible");
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void attack(AdventureCharacter otherCharacter) {
        if (!isAlive())
            throw new RuntimeException("Character must be alive to attack another character.");
        Integer damage = weapon.getDamage();
        otherCharacter.takeDamage(damage);
    }

    private void takeDamage(Integer damage) {
        hp -= damage;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public boolean equals(Object otherCharacter) {
        if (this == otherCharacter) {
            return true;
        }
        
        if (getClass() != otherCharacter.getClass()) {
            return false;
        }

        AdventureCharacter other = (AdventureCharacter) otherCharacter;
        return hp.equals(other.hp) && weapon.equals(other.weapon);
    }
}