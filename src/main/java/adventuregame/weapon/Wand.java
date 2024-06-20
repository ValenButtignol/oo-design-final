package adventuregame.weapon;

import adventuregame.Constants;
import adventuregame.FightStyle;

public class Wand extends Weapon {
    
    public Wand() {
        damage = Constants.WAND_DAMAGE;
        fightStyle = FightStyle.MAGE;
    }
}