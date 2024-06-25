package adventuregame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import adventuregame.character.AdventureCharacter;
import adventuregame.character.Gladiator;
import adventuregame.character.Knight;
import adventuregame.character.Wizard;
import adventuregame.factory.CharactersAndWeaponFactory;
import adventuregame.factory.HumanVersionFactory;
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

public class TestHumanVersionFactory {

    @ParameterizedTest
    @MethodSource("charactersAndWeaponsProvider")
    public void testCreateCharacter(String characterType, String weaponType, Class<? extends AdventureCharacter> expectedCharacterClass,
                                    Class<? extends Weapon> expectedWeaponClass) {

        CharactersAndWeaponFactory factory = new HumanVersionFactory();
        Weapon weapon = factory.createWeapon(weaponType);
        AdventureCharacter character = factory.createCharacter(characterType, weapon);
        
        assertTrue(character.getClass().equals(expectedCharacterClass));
        assertTrue(weapon.getClass().equals(expectedWeaponClass));
    }

    private static Stream<Arguments> charactersAndWeaponsProvider() {
        return Stream.of(
            Arguments.of("gladiator", "long sword", Gladiator.class, LongSword.class),
            Arguments.of("knight", "short sword", Knight.class, ShortSword.class),
            Arguments.of("wizard", "staff", Wizard.class, Staff.class),
            Arguments.of("gladiator", "short sword", Gladiator.class, ShortSword.class),
            Arguments.of("knight", "bare fist", Knight.class, BareFist.class)
        );
    }

    @ParameterizedTest
    @MethodSource("weaponAndGemsProvider")
    public void testAddGem(String weaponType, String gemType, Class<? extends GemDecorator> expectedGemClass) {
                            
        CharactersAndWeaponFactory factory = new HumanVersionFactory();
        Weapon weapon = factory.createWeapon(weaponType);
        weapon = factory.addGem(weapon, gemType);
        
        assertTrue(weapon.getClass().equals(expectedGemClass));
    }

    private static Stream<Arguments> weaponAndGemsProvider() {
        return Stream.of(
            Arguments.of("wand", "red", RedGem.class),
            Arguments.of("staff", "blue", BlueGem.class),
            Arguments.of("short sword", "green", GreenGem.class)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidCharactersProvider")
    public void testCreateCharacterWithInvalidType(String characterType, String weaponType, String expectedMessage) {
        CharactersAndWeaponFactory factory = new HumanVersionFactory();
        Weapon weapon = factory.createWeapon(weaponType);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.createCharacter(characterType, weapon);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    private static Stream<Arguments> invalidCharactersProvider() {
        return Stream.of(
            Arguments.of(null, "long sword", "Character type cannot be null"),
            Arguments.of("dwarf", "long sword", "Invalid character type")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidWeaponsProvider")
    public void testCreateWeaponWithInvalidType(String weaponType, String expectedMessage) {
        CharactersAndWeaponFactory factory = new HumanVersionFactory();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.createWeapon(weaponType);
        });
        
        assertEquals(expectedMessage, exception.getMessage());
    }

    private static Stream<Arguments> invalidWeaponsProvider() {
        return Stream.of(
            Arguments.of(null, "Weapon type cannot be null"),
            Arguments.of("hammer", "Invalid weapon type")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidGemsProvider")
    public void testAddGemWithInvalidInputs(Weapon weapon, String gemType, String expectedMessage) {
        CharactersAndWeaponFactory factory = new HumanVersionFactory();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.addGem(weapon, gemType);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    private static Stream<Arguments> invalidGemsProvider() {
        return Stream.of(
            Arguments.of(null, "red", "Weapon cannot be null"),
            Arguments.of(new Wand(), null, "Gem type cannot be null"),
            Arguments.of(new Wand(), "topaz", "Invalid gem type")
        );
    }
}