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
        if (weapon.getFightStyle() != fightStyle)
            throw new IllegalArgumentException("Weapon's fight style not compatible");        
        this.weapon = weapon;
        hp = Constants.GLADIATOR_HP;
        fightStyle = FightStyle.MELEE;
    }
}