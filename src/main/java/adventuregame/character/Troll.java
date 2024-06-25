package adventuregame.character;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class Troll extends AdventureCharacter {
    
    public Troll() {
        super();
        hp = Constants.TROLL_HP;
        fightStyle = FightStyle.MELEE;
    }

    public Troll(Weapon weapon) {
        hp = Constants.TROLL_HP;
        fightStyle = FightStyle.MELEE;
        setWeapon(weapon);
    }

    @Override
    public String toString() {
        return "Troll";
    }

    @Override
    public int hashCode() {
        return Constants.TROLL_HP + weapon.hashCode();
    }
}
