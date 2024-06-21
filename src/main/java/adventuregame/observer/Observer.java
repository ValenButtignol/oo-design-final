package adventuregame.observer;

import adventuregame.character.AdventureCharacter;

public interface Observer {
    public void updateStart(AdventureCharacter character1, AdventureCharacter character2);
    public void updateAttack(AdventureCharacter attacker, AdventureCharacter target);
    public void updateWinner(AdventureCharacter winner, AdventureCharacter loser);
}