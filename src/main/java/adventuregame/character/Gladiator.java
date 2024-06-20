package adventuregame.character;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class Gladiator extends AdventureCharacter {
    
    public Gladiator() {
        super();
        hp = Constants.GLADIATOR_HP;
        fightStyle = FightStyle.MELEE;
    }

    public Gladiator(Weapon weapon) {
        super(weapon);
        hp = Constants.GLADIATOR_HP;
        fightStyle = FightStyle.MELEE;
    }
}