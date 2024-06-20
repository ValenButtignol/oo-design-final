package adventuregame;

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
}