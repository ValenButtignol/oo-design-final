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

    public AdventureCharacter(Weapon weapon) {
        assert(weapon.getFightStyle() == fightStyle): "Weapon's fight style not compatible";
        this.weapon = weapon;
    }

    public void setWeapon(Weapon weapon) {
        assert(weapon.getFightStyle() == fightStyle): "Weapon's fight style not compatible";
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void attack(AdventureCharacter otherCharacter) {
        assert(isAlive()): "Character must be alive to attack another character.";
        Integer damage = weapon.getDamage();
        otherCharacter.takeDamage(damage);
    }

    private void takeDamage(Integer damage) {
        hp -= damage;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}