package adventuregame;

import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import java.util.List;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import adventuregame.character.AdventureCharacter;
import adventuregame.character.Dwarf;
import adventuregame.character.Gladiator;
import adventuregame.character.Knight;
import adventuregame.character.Orc;
import adventuregame.character.Troll;
import adventuregame.character.Wizard;
import adventuregame.displays.MockDisplayElement;
import adventuregame.observer.StatsObserver;
import adventuregame.weapon.Axe;
import adventuregame.weapon.Bow;
import adventuregame.weapon.Hammer;
import adventuregame.weapon.LongSword;
import adventuregame.weapon.ShortSword;
import adventuregame.weapon.Staff;
import adventuregame.weapon.Wand;
import adventuregame.weapon.gem.BlueGem;
import adventuregame.weapon.gem.GreenGem;
import adventuregame.weapon.gem.RedGem;
import adventuregame.weapon.gem.SapphireGem;
import adventuregame.weapon.gem.TopazGem;

public class TestStatsObserver {

    @ParameterizedTest
    @MethodSource("statsObserverProvider")
    public void testStatsObserverWithOneFight(BattleArena battleArena, List<String> expectedDisplayList) {
        MockDisplayElement displayElement = new MockDisplayElement();
        StatsObserver battleStartObserver = new StatsObserver(battleArena, displayElement);
        battleArena.fight();
        assert(displayElement.getDisplayList().equals(expectedDisplayList));
    }

    private static Stream<Object> statsObserverProvider() {
        return Stream.of(
            Arguments.of(new BattleArena(new Gladiator(new LongSword()), new Wizard(new Staff())),
                List.of("Wins count:", "Gladiator with Long Sword: 1")),
            Arguments.of(new BattleArena(new Wizard(new Staff()), new Knight()),
                List.of("Wins count:", "Wizard with Staff: 1"))
            );
    }

    @ParameterizedTest
    @MethodSource("twoFightsStatsObserverProvider")
    public void testStatsObserverWithTwoFights(AdventureCharacter c1, AdventureCharacter c2, AdventureCharacter c3, 
        AdventureCharacter c4, List<String> firstExpectedDisplay, List<String> secondExpectedDisplay) {
            BattleArena battleArena = new BattleArena(c1, c2);
            MockDisplayElement displayElement = new MockDisplayElement();
            StatsObserver battleStartObserver = new StatsObserver(battleArena, displayElement);

            battleArena.fight();
            assert(displayElement.getDisplayList().equals(firstExpectedDisplay));

            battleArena.setCharacters(c3, c4);
            displayElement.clearDisplayList();
            battleArena.fight();
            assert(displayElement.getDisplayList().equals(secondExpectedDisplay));
    }

    private static Stream<Object> twoFightsStatsObserverProvider() {
        return Stream.of(
            Arguments.of(new Gladiator(new LongSword()), new Wizard(new Staff()),
                new Gladiator(new LongSword()), new Wizard(new Staff()),
                List.of("Wins count:", "Gladiator with Long Sword: 1"), 
                List.of("Wins count:", "Gladiator with Long Sword: 2")),
            Arguments.of(new Wizard(new Staff()), new Knight(),
                new Wizard(new RedGem(new Staff())), new Wizard(new Staff()),
                List.of("Wins count:", "Wizard with Staff: 1"), 
                List.of("Wins count:", "Wizard with Staff: 1", "Wizard with Staff, Red Gem: 1")),
            Arguments.of(new Wizard(new Staff()), new Knight(),
                new Wizard(new RedGem(new Wand())), new Troll(new Hammer()),    // Same character w/ different weapons but same damage
                List.of("Wins count:", "Wizard with Staff: 1"), 
                List.of("Wins count:", "Wizard with Staff: 1", "Wizard with Wand, Red Gem: 1")),
            Arguments.of(new Dwarf(new TopazGem(new SapphireGem(new Hammer()))), new Orc(new Bow()),
                new Dwarf(new Axe()), new Gladiator(),    // Same character w/ different weapons but same damage
                List.of("Wins count:", "Dwarf with Hammer, Sapphire Gem, Topaz Gem: 1"), 
                List.of("Wins count:", "Dwarf with Axe: 1", "Dwarf with Hammer, Sapphire Gem, Topaz Gem: 1")),
            Arguments.of(new Wizard(new Staff()), new Knight(),
                new Wizard(new Staff()), new Knight(),
                List.of("Wins count:", "Wizard with Staff: 1"),
                List.of("Wins count:", "Wizard with Staff: 2")),
            Arguments.of(new Troll(new RedGem(new Axe())), new Knight(new BlueGem(new ShortSword())),
                new Troll(new RedGem(new Axe())), new Knight(new GreenGem(new ShortSword())),
                List.of("Wins count:", "Troll with Axe, Red Gem: 1"), 
                List.of("Wins count:", "Troll with Axe, Red Gem: 2")),
            Arguments.of(new Orc(new Bow()), new Knight(),
                new Orc(new RedGem(new RedGem(new Bow()))), new Troll(new BlueGem(new Axe())),
                List.of("Wins count:", "Orc with Bow: 1"), 
                List.of("Wins count:", "Orc with Bow: 1", "Orc with Bow, Red Gem, Red Gem: 1"))
            );
    }
}