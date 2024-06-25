package adventuregame.character;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class Wizard extends AdventureCharacter {
    
    public Wizard() {
        super();
        hp = Constants.WIZARD_HP;
        fightStyle = FightStyle.MAGE;
    }

    public Wizard(Weapon weapon) {
        hp = Constants.WIZARD_HP;
        fightStyle = FightStyle.MAGE;
        setWeapon(weapon);
    }

    @Override
    public String toString() {
        return "Wizard";
    }

    @Override
    public int hashCode() {
        return Constants.WIZARD_HP + weapon.hashCode();
    }
}