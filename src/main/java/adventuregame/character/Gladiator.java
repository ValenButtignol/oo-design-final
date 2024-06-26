package adventuregame.character;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class Gladiator extends AdventureCharacter {
    
    public Gladiator() {
        super();
        setHp(Constants.GLADIATOR_HP);
        fightStyle = FightStyle.MELEE;
    }

    public Gladiator(Weapon weapon) {
        setHp(Constants.GLADIATOR_HP);
        fightStyle = FightStyle.MELEE;
        setWeapon(weapon);
    }

    @Override
    public String toString() {
        return "Gladiator";
    }

    @Override
    public int hashCode() {
        return initHp + weapon.hashCode();
    }
}