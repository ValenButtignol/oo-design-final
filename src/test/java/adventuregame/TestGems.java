package adventuregame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import adventuregame.factory.CharactersAndWeaponFactory;
import adventuregame.factory.MixedVersionFactory;
import adventuregame.weapon.Weapon;

public class TestGems {
    
    @ParameterizedTest
    @MethodSource("weaponsWithGemsProvider")
    public void testWeaponsWithGems(String weaponType, List<String> gems, Integer expectedDamage) {
        CharactersAndWeaponFactory factory = new MixedVersionFactory();
        Weapon weapon = factory.createWeapon(weaponType);
        for (String gem : gems) {
            weapon = factory.addGem(weapon, gem);
        }
        assertEquals(weapon.getDamage(), expectedDamage);
    }

    private static Stream<Object> weaponsWithGemsProvider() {
        return Stream.of(
            Arguments.of("wand", List.of("red", "blue"), 180),
            Arguments.of("long sword", List.of("green"), 100),
            Arguments.of("short sword", List.of("red", "blue", "green", "blue"), 185),
            Arguments.of("staff", List.of("green", "blue"), 195),
            Arguments.of("bow", List.of("amethyst", "sapphire"), 110),
            Arguments.of("axe", List.of("topaz"), 135),
            Arguments.of("hammer", List.of("sapphire", "topaz"), 90)
        );
    }

    @ParameterizedTest
    @MethodSource("gemOverflowProvider")
    public void negativeTestGemsOverflow(String weaponType, List<String> gems) {
        CharactersAndWeaponFactory factory = new MixedVersionFactory();
        Weapon weapon = factory.createWeapon(weaponType);

        Exception exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            addGems(weapon, gems, factory);
        });

        assertEquals("No more stacking of gems is allowed", exceptionThrown.getMessage());
    }

    private static Stream<Object> gemOverflowProvider() {
        return Stream.of(
            Arguments.of("wand", List.of("red", "blue", "green", "red")),
            Arguments.of("long sword", List.of("green", "red")),
            Arguments.of("short sword", List.of("red", "blue", "green", "blue", "blue")),
            Arguments.of("staff", List.of("green", "blue", "red")),
            Arguments.of("bare fist", List.of("green")),
            Arguments.of("bow", List.of("amethyst", "sapphire", "topaz")),
            Arguments.of("axe", List.of("topaz", "blue", "amethyst", "green")),
            Arguments.of("hammer", List.of("sapphire", "red", "blue"))
        );
    }

    private static void addGems(Weapon weapon, List<String> gems, CharactersAndWeaponFactory factory) {
        for (String gem : gems) {
            weapon = factory.addGem(weapon, gem);
        }
    }
}