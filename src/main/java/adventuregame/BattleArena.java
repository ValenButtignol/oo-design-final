package adventuregame;

import adventuregame.character.AdventureCharacter;

public class BattleArena {
    private AdventureCharacter character1;
    private AdventureCharacter character2;
    private AdventureCharacter winner;
    private boolean isCharacter1Turn;

    public BattleArena(AdventureCharacter character1, AdventureCharacter character2) {
        this.character1 = character1;
        this.character2 = character2;
        this.isCharacter1Turn = true;
    }

    public AdventureCharacter getWinner() {
        return winner;
    }

    public void fight() {
        while (!isEnded()) {
            if (isCharacter1Turn) {
                character1.attack(character2);
            } else {
                character2.attack(character1);
            }
        }

        setWinner();
    }

    private boolean isEnded() {
       return !character1.isAlive() || !character2.isAlive();
    }

    private void setWinner() {
        if (character1.isAlive()) {
            winner = character1;
        } else {
            winner = character2;
        }
    }
}