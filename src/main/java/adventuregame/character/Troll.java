package adventuregame.character;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class Troll extends AdventureCharacter {
    
    public Troll() {
        super();
        setHp(Constants.TROLL_HP);
        fightStyle = FightStyle.MELEE;
    }

    public Troll(Weapon weapon) {
        setHp(Constants.TROLL_HP);
        fightStyle = FightStyle.MELEE;
        setWeapon(weapon);
    }

    @Override
    public String toString() {
        return "Troll";
    }

    @Override
    public int hashCode() {
        return initHp + weapon.hashCode();
    }
}