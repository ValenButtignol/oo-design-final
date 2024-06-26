package adventuregame.character;

import adventuregame.FightStyle;
import adventuregame.weapon.BareFist;
import adventuregame.weapon.Weapon;

public abstract class AdventureCharacter {
    protected Weapon weapon;
    protected Integer hp;
    protected Integer initHp;
    protected FightStyle fightStyle;

    public AdventureCharacter() {
        weapon = new BareFist();
    }

    public void setWeapon(Weapon weapon) {
        if (weapon.getFightStyle() != fightStyle && weapon.getFightStyle() != FightStyle.DEFAULT)
            throw new IllegalArgumentException("Weapon's fight style not compatible");
        this.weapon = weapon;
    }

    protected void setHp(Integer hp) {
        this.hp = hp;
        this.initHp = hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Integer getHp() {
        return hp;
    }

    public void attack(AdventureCharacter otherCharacter) {
        if (!isAlive())
            throw new RuntimeException("Character must be alive to attack another character.");
        Integer damage = weapon.getDamage();
        otherCharacter.takeDamage(damage);
    }

    private void takeDamage(Integer damage) {
        hp -= damage;
        hp = hp < 0 ? 0 : hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }
   
    public void reset() {
        hp = initHp;
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
        return weapon.equals(other.weapon);
    }
}