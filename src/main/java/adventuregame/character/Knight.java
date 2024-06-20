package adventuregame.character;

import adventuregame.Constants;
import adventuregame.FightStyle;
import adventuregame.weapon.Weapon;

public class Knight extends AdventureCharacter {
    
    public Knight() {
        super();
        hp = Constants.KNIGHT_HP;
        fightStyle = FightStyle.MELEE;
    }

    public Knight(Weapon weapon) {
        if (weapon.getFightStyle() != FightStyle.MELEE)
            throw new IllegalArgumentException("Weapon's fight style not compatible");
        this.weapon = weapon;
        hp = Constants.KNIGHT_HP;
        fightStyle = FightStyle.MELEE;
    }
}