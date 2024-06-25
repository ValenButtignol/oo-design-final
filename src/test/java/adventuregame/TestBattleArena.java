package adventuregame;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
            Arguments.of(new Wizard(), new Wand(), new Staff()),
            Arguments.of(new Orc(), new BareFist(), new Bow()),
            Arguments.of(new Dwarf(), new Axe(), new Hammer()),
            Arguments.of(new Troll(), new Hammer(), new Axe())
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
    public void testBattleArenaWithGems(AdventureCharacter character1, Weapon weapon1, List<Class <? extends GemDecorator>> gems1, 
            AdventureCharacter character2, Weapon weapon2, List<Class <? extends GemDecorator>> gems2) {
        
        // arrange
        weapon1 = createWeaponWithGem(gems1, weapon1);
        weapon2 = createWeaponWithGem(gems2, weapon2);
        character1.setWeapon(weapon1);
        character2.setWeapon(weapon2);

        BattleArena battleArena = new BattleArena(character1, character2);

        // act
        battleArena.fight();

        // assert
        assert(battleArena.getWinner().equals(character1));
    }

    private static Stream<Object> charactersWithGemsProvider() {
        return Stream.of(
            Arguments.of(new Gladiator(), new LongSword(), List.of(RedGem.class), new Wizard(), new Wand(), List.of(GreenGem.class)),
            Arguments.of(new Wizard(), new Staff(), List.of(GreenGem.class, RedGem.class), new Knight(), new ShortSword(), List.of(GreenGem.class, BlueGem.class)),
            Arguments.of(new Knight(), new ShortSword(), List.of(RedGem.class, BlueGem.class, GreenGem.class, BlueGem.class), new Wizard(), new Staff(), List.of(RedGem.class)),
            Arguments.of(new Troll(), new Hammer(), List.of(SapphireGem.class, TopazGem.class), new Dwarf(), new Axe(), List.of(AmethystGem.class)),
            Arguments.of(new Orc(), new Bow(), List.of(TopazGem.class), new Orc(), new Bow(), List.of(SapphireGem.class, AmethystGem.class))
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
            Arguments.of(new Wizard(), new LongSword()),
            Arguments.of(new Dwarf(), new Bow()),
            Arguments.of(new Troll(), new Wand()),
            Arguments.of(new Orc(), new LongSword()),
            Arguments.of(new Wizard(), new Axe())
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
            Arguments.of(Wizard.class, new LongSword()),
            Arguments.of(Dwarf.class, new Staff()),
            Arguments.of(Orc.class, new Wand()),
            Arguments.of(Troll.class, new Bow())
        );
    }

    private static AdventureCharacter createCharacter(Class <? extends AdventureCharacter> characterClass, Weapon weapon) {
        if (characterClass == Gladiator.class) {
            return new Gladiator(weapon);
        } else if (characterClass == Knight.class) {
            return new Knight(weapon);
        } else if (characterClass == Wizard.class) {
            return new Wizard(weapon);
        } if (characterClass == Troll.class) { 
            return new Troll(weapon);
        } if (characterClass == Orc.class) {
            return new Orc(weapon);
        } else {
            return new Dwarf(weapon);
        }
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
                weapon =  new AmethystGem(weapon);
            }
        }
        return weapon;
    }
}