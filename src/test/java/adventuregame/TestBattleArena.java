package adventuregame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import adventuregame.character.AdventureCharacter;
import adventuregame.character.Dwarf;
import adventuregame.character.Gladiator;
import adventuregame.character.Knight;
import adventuregame.character.Orc;
import adventuregame.character.Troll;
import adventuregame.character.Wizard;
import adventuregame.factory.AdventureGameFactoryClient;
import adventuregame.factory.CharactersAndWeaponFactory;
import adventuregame.factory.MixedVersionFactory;
import adventuregame.weapon.Axe;
import adventuregame.weapon.BareFist;
import adventuregame.weapon.Bow;
import adventuregame.weapon.Hammer;
import adventuregame.weapon.LongSword;
import adventuregame.weapon.ShortSword;
import adventuregame.weapon.Staff;
import adventuregame.weapon.Wand;
import adventuregame.weapon.Weapon;

public class TestBattleArena {
    
    @ParameterizedTest
    @MethodSource("weaponsChangeProvider")
    public void testWeaponChange(AdventureCharacter adventureCharacter, Weapon firstWeapon, Weapon secondWeapon) {
        adventureCharacter.setWeapon(firstWeapon);
        assert(adventureCharacter.getWeapon().equals(firstWeapon));
        
        adventureCharacter.setWeapon(secondWeapon);
        assert(adventureCharacter.getWeapon().equals(secondWeapon));
    }

    private static Stream<Object> weaponsChangeProvider() {
        return Stream.of(
            Arguments.of(new Gladiator(), new ShortSword(), new LongSword()),
            Arguments.of(new Knight(), new LongSword(), new ShortSword()),
            Arguments.of(new Wizard(), new Wand(), new Staff()),
            Arguments.of(new Orc(), new BareFist(), new Bow()),
            Arguments.of(new Dwarf(), new Axe(), new Hammer()),
            Arguments.of(new Troll(), new Hammer(), new Axe())
        );
    }

    @ParameterizedTest
    @MethodSource("weaponsChangeProviderWithCreatedCharacters")
    public void testWeaponChangeFromCreatedCharacterWithWeapon(AdventureCharacter adventureCharacter, Weapon anotherWeapon) {
        
        Weapon oldWeapon = adventureCharacter.getWeapon();
        adventureCharacter.setWeapon(anotherWeapon);
        assert(adventureCharacter.getWeapon().equals(anotherWeapon));
        assertFalse(oldWeapon.equals(anotherWeapon));
    }

    private static Stream<Object> weaponsChangeProviderWithCreatedCharacters() {
        return Stream.of(
            Arguments.of(new Gladiator(new ShortSword()), new LongSword()),
            Arguments.of(new Knight(new LongSword()), new ShortSword()),
            Arguments.of(new Wizard(new Wand()), new Staff()),
            Arguments.of(new Dwarf(new Axe()), new Hammer()),
            Arguments.of(new Orc(new Bow()), new BareFist()),
            Arguments.of(new Troll(new Hammer()), new Axe())
        );
    }

    @ParameterizedTest
    @MethodSource("charactersProvider")
    public void testBattleArena(AdventureCharacter character1, AdventureCharacter character2) {
        BattleArena battleArena = new BattleArena(character1, character2);
        battleArena.fight();
        assert(battleArena.getWinner().equals(character1));
    }

    private static Stream<Object> charactersProvider() {
        return Stream.of(
            Arguments.of(new Gladiator(new ShortSword()), new Wizard(new Wand())),
            Arguments.of(new Knight(new LongSword()), new Gladiator(new ShortSword())),
            Arguments.of(new Wizard(new Staff()), new Knight(new LongSword()),
            Arguments.of(new Dwarf(new Axe()), new Orc()),
            Arguments.of(new Troll(), new Dwarf()),
            Arguments.of(new Orc(new Bow()), new Orc()))
        );
    }

    @ParameterizedTest
    @MethodSource("charactersWithGemsProvider")
    public void testBattleArenaWithGems(String characterType1, String weaponType1, List<String> gems1, String characterType2, String weaponType2, List<String> gems2) {
        AdventureGameFactoryClient client = new AdventureGameFactoryClient(new MixedVersionFactory());

        // arrange
        AdventureCharacter c1 = client.createCharacterWithWeapon(characterType1, weaponType1, gems1);
        AdventureCharacter c2 = client.createCharacterWithWeapon(characterType2, weaponType2, gems2);
        BattleArena battleArena = new BattleArena(c1, c2);

        // act
        battleArena.fight();

        // assert
        assert(battleArena.getWinner().equals(c1));
    }

    private static Stream<Object> charactersWithGemsProvider() {
        return Stream.of(
            Arguments.of("gladiator", "long sword", List.of("red"), "wizard", "wand", List.of("green")),
            Arguments.of("wizard", "staff", List.of("green", "red"), "knight", "short sword", List.of("green", "blue")),
            Arguments.of("knight", "short sword", List.of("red", "blue", "green", "blue"), "wizard", "staff", List.of("red")),
            Arguments.of("troll", "hammer", List.of("sapphire", "topaz"), "dwarf", "axe", List.of("amethyst")),
            Arguments.of("orc", "bow", List.of("topaz"), "orc", "bow", List.of("sapphire", "amethyst")) 
        );
    }

    @ParameterizedTest
    @MethodSource("characterAndWeaponProvider")
    public void negativeTestSetWeapons(String characterType, String weaponType) {  
        CharactersAndWeaponFactory factory = new MixedVersionFactory();
        Weapon barefist = factory.createWeapon("bare fist");
        AdventureCharacter c1 = factory.createCharacter(characterType, barefist);
        Weapon weaponToBeSetted = factory.createWeapon(weaponType);
        // arrange
        Exception exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            c1.setWeapon(weaponToBeSetted);
        });
        assertEquals("Weapon's fight style not compatible", exceptionThrown.getMessage());
    }

    @ParameterizedTest
    @MethodSource("characterAndWeaponProvider")
    public void negativeTestCharacterWithWeaponCreation(String characterType, String weaponType) {  
        AdventureGameFactoryClient client = new AdventureGameFactoryClient(new MixedVersionFactory());
        // arrange
        Exception exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            client.createCharacterWithWeapon(characterType, weaponType);
        });
        assertEquals("Weapon's fight style not compatible", exceptionThrown.getMessage());
    }

    private static Stream<Object> characterAndWeaponProvider() {
        return Stream.of(
            Arguments.of("gladiator", "wand"),
            Arguments.of("gladiator", "staff"),
            Arguments.of("knight", "staff"),
            Arguments.of("knight", "wand"),
            Arguments.of("wizard", "short sword"),
            Arguments.of("wizard", "long sword"),
            Arguments.of("dwarf", "bow"),
            Arguments.of("troll", "wand"),
            Arguments.of("orc", "long sword"),
            Arguments.of("wizard", "axe")
        );
    }
}