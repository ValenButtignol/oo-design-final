package adventuregame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import adventuregame.character.AdventureCharacter;
import adventuregame.character.Dwarf;
import adventuregame.character.Orc;
import adventuregame.character.Troll;
import adventuregame.factory.CharactersAndWeaponFactory;
import adventuregame.factory.MonsterVersionFactory;
import adventuregame.weapon.Axe;
import adventuregame.weapon.BareFist;
import adventuregame.weapon.Bow;
import adventuregame.weapon.Hammer;
import adventuregame.weapon.Weapon;
import adventuregame.weapon.gem.AmethystGem;
import adventuregame.weapon.gem.GemDecorator;
import adventuregame.weapon.gem.SapphireGem;
import adventuregame.weapon.gem.TopazGem;

public class TestMonsterVersionFactory {
    @ParameterizedTest
    @MethodSource("charactersAndWeaponsProvider")
    public void testCreateCharacter(String characterType, String weaponType, Class<? extends AdventureCharacter> expectedCharacterClass,
                                    Class<? extends Weapon> expectedWeaponClass) {

        CharactersAndWeaponFactory factory = new MonsterVersionFactory();
        Weapon weapon = factory.createWeapon(weaponType);
        AdventureCharacter character = factory.createCharacter(characterType, weapon);
        
        assertTrue(character.getClass().equals(expectedCharacterClass));
        assertTrue(weapon.getClass().equals(expectedWeaponClass));
    }

    private static Stream<Arguments> charactersAndWeaponsProvider() {
        return Stream.of(
            Arguments.of("dwarf", "axe", Dwarf.class, Axe.class),
            Arguments.of("dwarf", "hammer", Dwarf.class, Hammer.class),
            Arguments.of("orc", "bow", Orc.class, Bow.class),
            Arguments.of("troll", "hammer", Troll.class, Hammer.class),
            Arguments.of("troll", "axe", Troll.class, Axe.class),
            Arguments.of("orc", "bare fist", Orc.class, BareFist.class)
        );
    }

    @ParameterizedTest
    @MethodSource("weaponAndGemsProvider")
    public void testAddGem(String weaponType, String gemType, Class<? extends GemDecorator> expectedGemClass) {
                            
        CharactersAndWeaponFactory factory = new MonsterVersionFactory();
        Weapon weapon = factory.createWeapon(weaponType);
        weapon = factory.addGem(weapon, gemType);
        
        assertTrue(weapon.getClass().equals(expectedGemClass));
    }

    private static Stream<Arguments> weaponAndGemsProvider() {
        return Stream.of(
            Arguments.of("axe", "amethyst", AmethystGem.class),
            Arguments.of("hammer", "sapphire", SapphireGem.class),
            Arguments.of("bow", "topaz", TopazGem.class)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidCharactersProvider")
    public void testCreateCharacterWithInvalidType(String characterType, String weaponType, String expectedMessage) {
        CharactersAndWeaponFactory factory = new MonsterVersionFactory();
        Weapon weapon = factory.createWeapon(weaponType);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.createCharacter(characterType, weapon);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    private static Stream<Arguments> invalidCharactersProvider() {
        return Stream.of(
            Arguments.of(null, "axe", "Character type cannot be null"),
            Arguments.of("knight", "hammer", "Invalid character type")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidWeaponsProvider")
    public void testCreateWeaponWithInvalidType(String weaponType, String expectedMessage) {
        CharactersAndWeaponFactory factory = new MonsterVersionFactory();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.createWeapon(weaponType);
        });
        
        assertEquals(expectedMessage, exception.getMessage());
    }

    private static Stream<Arguments> invalidWeaponsProvider() {
        return Stream.of(
            Arguments.of(null, "Weapon type cannot be null"),
            Arguments.of("wand", "Invalid weapon type")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidGemsProvider")
    public void testAddGemWithInvalidInputs(Weapon weapon, String gemType, String expectedMessage) {
        CharactersAndWeaponFactory factory = new MonsterVersionFactory();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.addGem(weapon, gemType);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    private static Stream<Arguments> invalidGemsProvider() {
        return Stream.of(
            Arguments.of(null, "topaz", "Weapon cannot be null"),
            Arguments.of(new Bow(), null, "Gem type cannot be null"),
            Arguments.of(new Hammer(), "red", "Invalid gem type")
        );
    }
}