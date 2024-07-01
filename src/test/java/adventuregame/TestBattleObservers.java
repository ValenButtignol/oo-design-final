package adventuregame;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import adventuregame.character.Gladiator;
import adventuregame.character.Knight;
import adventuregame.character.Wizard;
import adventuregame.displays.MockDisplayElement;
import adventuregame.observer.AttackObserver;
import adventuregame.observer.BattleStartObserver;
import adventuregame.observer.BattleEndObserver;
import adventuregame.weapon.LongSword;
import adventuregame.weapon.ShortSword;
import adventuregame.weapon.Staff;
import adventuregame.weapon.Wand;

public class TestBattleObservers {

    @ParameterizedTest
    @MethodSource("startMessageObserverProvider")
    public void testBattleStartObserver(BattleArena battleArena, List<String> expectedDisplayList) {
        MockDisplayElement displayElement = new MockDisplayElement();
        BattleStartObserver battleStartObserver = new BattleStartObserver(battleArena, displayElement);
        battleArena.fight();
        assert (displayElement.getDisplayList().equals(expectedDisplayList));
    }

    private static Stream<Object> startMessageObserverProvider() {
        return Stream.of(
                Arguments.of(new BattleArena(new Gladiator(new ShortSword()), new Wizard(new Staff())),
                        List.of("Battle Started: Gladiator with Short Sword vs Wizard with Staff")),

                Arguments.of(new BattleArena(new Wizard(new Staff()), new Gladiator(new ShortSword())),
                        List.of("Battle Started: Wizard with Staff vs Gladiator with Short Sword")),

                Arguments.of(new BattleArena(new Knight(new LongSword()), new Gladiator()),
                        List.of("Battle Started: Knight with Long Sword vs Gladiator with Bare Fists")),

                Arguments.of(new BattleArena(new Wizard(new Wand()), new Knight()),
                        List.of("Battle Started: Wizard with Wand vs Knight with Bare Fists")));
    }

    @ParameterizedTest
    @MethodSource("attackObserverProvider")
    public void testAttackObserver(BattleArena battleArena, List<String> expectedDisplayList) {
        MockDisplayElement displayElement = new MockDisplayElement();
        AttackObserver battlAttackObserver = new AttackObserver(battleArena, displayElement);
        battleArena.attack();
        assert (displayElement.getDisplayList().equals(expectedDisplayList));
    }

    private static Stream<Object> attackObserverProvider() {
        return Stream.of(
            Arguments.of(new BattleArena(new Gladiator(new LongSword()), new Wizard(new Staff())),
                List.of("Gladiator attacks Wizard with Long Sword!", "- Gladiator deals 85 damage", "- Wizard has 215 health left!"))
            );
    }

    @ParameterizedTest
    @MethodSource("winnerObserverProvider")
    public void testWinnerObserver(BattleArena battleArena, List<String> expectedDisplayList) {
        MockDisplayElement displayElement = new MockDisplayElement();
        BattleEndObserver battleEndObserver = new BattleEndObserver(battleArena, displayElement);
        battleArena.fight();
        assert(displayElement.getDisplayList().equals(expectedDisplayList));
    }

    private static Stream<Object> winnerObserverProvider() {
        return Stream.of(
            Arguments.of(new BattleArena(new Gladiator(new LongSword()), new Wizard(new Staff())),
                List.of("Gladiator Winner Winner Chicken Dinner!"))
            );
    }
}