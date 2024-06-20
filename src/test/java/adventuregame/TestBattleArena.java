package adventuregame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import adventuregame.character.AdventureCharacter;
import adventuregame.character.Gladiator;
import adventuregame.character.Knight;
import adventuregame.character.Wizard;
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
        assert(adventureCharacter.getWeapon().getClass() == firstWeapon.getClass());

        adventureCharacter.setWeapon(secondWeapon);
        assert(adventureCharacter.getWeapon().getClass() == secondWeapon.getClass());
    }

    private static Stream<Object> weaponsChangeProvider() {
        return Stream.of(
            Arguments.of(new Gladiator(), new ShortSword(), new LongSword()),
            Arguments.of(new Knight(), new LongSword(), new ShortSword()),
            Arguments.of(new Wizard(), new Wand(), new Staff())
        );
    }

    @ParameterizedTest
    @MethodSource("weaponsChangeProviderWithCreatedCharacters")
    public void testWeaponChangeFromCreatedCharacterWithWeapon(AdventureCharacter adventureCharacter, Weapon anotherWeapon) {
        
        Class<? extends Weapon> oldWeaponClass = adventureCharacter.getWeapon().getClass();
        adventureCharacter.setWeapon(anotherWeapon);
        assert(adventureCharacter.getWeapon().getClass() == anotherWeapon.getClass());
        assert(oldWeaponClass != anotherWeapon.getClass());
    }

    private static Stream<Object> weaponsChangeProviderWithCreatedCharacters() {
        return Stream.of(
            Arguments.of(new Gladiator( new ShortSword()), new LongSword()),
            Arguments.of(new Knight(new LongSword()), new ShortSword()),
            Arguments.of(new Wizard( new Wand()), new Staff())
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
            Arguments.of(new Wizard(new Staff()), new Knight(new LongSword()))
        );
    }

    @ParameterizedTest
    @MethodSource("characterAndWeaponProvider")
    public void negativeTestSetWeapons(AdventureCharacter character, Weapon weapon) {  
        Exception exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            character.setWeapon(weapon);
        });
        assertEquals("Weapon's fight style not compatible", exceptionThrown.getMessage());
    }

    private static Stream<Object> characterAndWeaponProvider() {
        return Stream.of(
            Arguments.of(new Gladiator(), new Wand()),
            Arguments.of(new Gladiator(), new Staff()),
            Arguments.of(new Knight(), new Staff()),
            Arguments.of(new Knight(), new Wand()),
            Arguments.of(new Wizard(), new ShortSword()),
            Arguments.of(new Wizard(), new LongSword())
        );
    }

    @ParameterizedTest
    @MethodSource("characterClassAndWeaponProvider")
    public void negativeTestCharacterWithWeaponCreation(Class <? extends AdventureCharacter> characterClass, Weapon weapon) {
        Exception exceptionThrown = assertThrows(IllegalArgumentException.class, () -> {
            createCharacter(characterClass, weapon);
        });
        assertEquals("Weapon's fight style not compatible", exceptionThrown.getMessage());
    }

    private static Stream<Object> characterClassAndWeaponProvider() {
        return Stream.of(
            Arguments.of(Gladiator.class, new Wand()),
            Arguments.of(Gladiator.class, new Staff()),
            Arguments.of(Knight.class, new Staff()),
            Arguments.of(Knight.class, new Wand()),
            Arguments.of(Wizard.class, new ShortSword()),
            Arguments.of(Wizard.class, new LongSword())
        );
    }

    private static AdventureCharacter createCharacter(Class <? extends AdventureCharacter> characterClass, Weapon weapon) {
        if (characterClass == Gladiator.class) {
            return new Gladiator(weapon);
        } else if (characterClass == Knight.class) {
            return new Knight(weapon);
        } else {
            return new Wizard(weapon);
        } 
    }
}