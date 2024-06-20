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
        if (weapon.getFightStyle() != FightStyle.MAGE)
            throw new IllegalArgumentException("Weapon's fight style not compatible");
        this.weapon = weapon;
        hp = Constants.WIZARD_HP;
        fightStyle = FightStyle.MAGE;
    }
}