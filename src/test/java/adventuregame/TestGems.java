package adventuregame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import adventuregame.weapon.Axe;
import adventuregame.weapon.BareFist;
import adventuregame.weapon.Bow;
import adventuregame.weapon.Hammer;
import adventuregame.weapon.LongSword;
import adventuregame.weapon.ShortSword;
import adventuregame.weapon.Staff;
import adventuregame.weapon.Wand;
import adventuregame.weapon.Weapon;
import adventuregame.weapon.gem.AmethystGem;
import adventuregame.weapon.gem.BlueGem;
import adventuregame.weapon.gem.GemDecorator;
import adventuregame.weapon.gem.GreenGem;
import adventuregame.weapon.gem.RedGem;
import adventuregame.weapon.gem.SapphireGem;
import adventuregame.weapon.gem.TopazGem;

public class TestGems {
    
    @ParameterizedTest
    @MethodSource("weaponsWithGemsProvider")
    public void testWeaponsWithGems(Weapon weapon, List<Class <? extends GemDecorator>> gems, Integer expectedDamage) {
        weapon = createWeaponWithGem(gems, weapon);
        
        assertEquals(weapon.getDamage(), expectedDamage);
    }

    private static Stream<Object> weaponsWithGemsProvider() {
        return Stream.of(
            Arguments.of(new Wand(), List.of(RedGem.class, BlueGem.class), 180),
            Arguments.of(new LongSword(), List.of(GreenGem.class), 100),
            Arguments.of(new ShortSword(), List.of(RedGem.class, BlueGem.class, GreenGem.class, BlueGem.class), 185),
            Arguments.of(new Staff(), List.of(GreenGem.class, BlueGem.class), 195),
            Arguments.of(new Bow(), List.of(AmethystGem.class, SapphireGem.class), 110),
            Arguments.of(new Axe(), List.of(TopazGem.class), 135),
            Arguments.of(new Hammer(), List.of(SapphireGem.class, TopazGem.class), 90)
        );
    }

    @ParameterizedTest
    @MethodSource("gemOverflowProvider")
    public void negativeTestGemsOverflow(Weapon weapon, List<Class <? extends GemDecorator>> gems) {
        Exception exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            
            createWeaponWithGem(gems, weapon);
        });

        assertEquals("No more stacking of gems is allowed", exceptionThrown.getMessage());
    }

    private static Stream<Object> gemOverflowProvider() {
        return Stream.of(
            Arguments.of(new Wand(), List.of(RedGem.class, BlueGem.class, GreenGem.class, RedGem.class)),
            Arguments.of(new LongSword(), List.of(GreenGem.class, RedGem.class)),
            Arguments.of(new ShortSword(), List.of(RedGem.class, BlueGem.class, GreenGem.class, BlueGem.class, BlueGem.class)),
            Arguments.of(new Staff(), List.of(GreenGem.class, BlueGem.class, RedGem.class)),
            Arguments.of(new BareFist(), List.of(GreenGem.class)),
            Arguments.of(new Bow(), List.of(TopazGem.class, AmethystGem.class, SapphireGem.class)),
            Arguments.of(new Axe(), List.of(TopazGem.class, BlueGem.class, AmethystGem.class, GreenGem.class)),
            Arguments.of(new Hammer(), List.of(SapphireGem.class, RedGem.class, BlueGem.class))
        );
    }

    private static Weapon createWeaponWithGem(List<Class <? extends GemDecorator>> gems, Weapon weapon) {
        for (Class <? extends GemDecorator> gem : gems) {
            if (gem == RedGem.class) {
                weapon = new RedGem(weapon);
            } else if (gem == BlueGem.class) {
                weapon =  new BlueGem(weapon);
            } else if (gem == GreenGem.class) {
                weapon = new GreenGem(weapon);
            } else if (gem == SapphireGem.class) {
                weapon = new SapphireGem(weapon);
            } else if (gem == TopazGem.class) {
                weapon = new TopazGem(weapon);
            } else {
                weapon = new AmethystGem(weapon);
            }
        }
        return weapon;
    }
}