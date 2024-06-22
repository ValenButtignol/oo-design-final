package adventuregame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import adventuregame.weapon.BareFist;
import adventuregame.weapon.LongSword;
import adventuregame.weapon.ShortSword;
import adventuregame.weapon.Staff;
import adventuregame.weapon.Wand;
import adventuregame.weapon.Weapon;
import adventuregame.weapon.gem.BlueGem;
import adventuregame.weapon.gem.GemDecorator;
import adventuregame.weapon.gem.GreenGem;
import adventuregame.weapon.gem.RedGem;

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
            Arguments.of(new Staff(), List.of(GreenGem.class, BlueGem.class), 195)
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
            Arguments.of(new BareFist(), List.of(GreenGem.class))
        );
    }

    private static Weapon createWeaponWithGem(List<Class <? extends GemDecorator>> gems, Weapon weapon) {
        for (Class <? extends GemDecorator> gem : gems) {
            if (gem == RedGem.class) {
                weapon = new RedGem(weapon);
            } else if (gem == BlueGem.class) {
                weapon =  new BlueGem(weapon);
            } else {
                weapon = new GreenGem(weapon);
            } 
        }
        return weapon;
    }
}