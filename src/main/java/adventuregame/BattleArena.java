package adventuregame;

import java.util.ArrayList;
import java.util.List;

import adventuregame.character.AdventureCharacter;
import adventuregame.observer.Observer;

public class BattleArena implements Subject {
    private AdventureCharacter character1;
    private AdventureCharacter character2;
    private AdventureCharacter winner;
    private boolean isCharacter1Turn;
    private List<Observer> observers;

    public BattleArena(AdventureCharacter character1, AdventureCharacter character2) {
        this.character1 = character1;
        this.character2 = character2;
        this.isCharacter1Turn = true;
        observers = new ArrayList<>();
    }

    public AdventureCharacter getWinner() {
        return winner;
    }

    public void setCharacters(AdventureCharacter character1, AdventureCharacter character2) {
        this.character1 = character1;
        this.character2 = character2;
    }

    public void fight() {
        notifyStart(character1, character2);
        while (!isEnded()) {
            attack();
        }

        setWinner();
        resetTurn();
        notifyEnd(winner);
    }

    public void attack() {
        if (isCharacter1Turn) {
            character1.attack(character2);
            notifyAttack(character1, character2);    
        } else {
            character2.attack(character1);
            notifyAttack(character2, character1);    
        }
        isCharacter1Turn = !isCharacter1Turn;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer); 
    }

    @Override
    public void notifyStart(AdventureCharacter character1, AdventureCharacter character2) {
        for (Observer observer : observers) {
            observer.updateStart(character1, character2);
        }
    }

    @Override
    public void notifyAttack(AdventureCharacter attacker, AdventureCharacter target) {
        for (Observer observer : observers) {
            observer.updateAttack(attacker, target);
        }
    }

    @Override
    public void notifyEnd(AdventureCharacter winner) {
        for (Observer observer : observers) {
            observer.updateWinner(winner);
        }
    }

    private boolean isEnded() {
       return !character1.isAlive() || !character2.isAlive();
    }

    private void setWinner() {
        if (character1.isAlive()) 
            winner = character1;
        else 
            winner = character2;
    }

    private void resetTurn() {
        isCharacter1Turn = true;
    }
}