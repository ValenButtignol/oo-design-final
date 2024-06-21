package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class ShortSword extends Weapon {
    
    public ShortSword() {
        damage = Constants.SHORT_SWORD_DAMAGE;
        fightStyle = FightStyle.MELEE;
    }

    @Override
    public String toString() {
        return "Short Sword";
    }
}