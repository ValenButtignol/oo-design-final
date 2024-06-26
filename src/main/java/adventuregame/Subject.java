package adventuregame;

import adventuregame.character.AdventureCharacter;
import adventuregame.observer.Observer;

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyStart(AdventureCharacter character1, AdventureCharacter character2);
    public void notifyAttack(AdventureCharacter attacker, AdventureCharacter target);
    public void notifyEnd(AdventureCharacter winner);
}