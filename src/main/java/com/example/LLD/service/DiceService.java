package com.example.LLD.service;

public class DiceService {
    private final int maxValue = 6;
    private final int maxRolls = 3;
    public int roll(int diceCount) {
        int rollValue = 0;
        for(int i=0;i<diceCount;i++){
            rollValue+=getOneDiceRoll();
        }
        return rollValue;
    }
    private int getOneDiceRoll(){
        return rollTheDice(0,1);
    }

    private int rollTheDice(int oneDiceRoll, int numberOfRolls){
        int randomNumber = getRandomNumber();
        oneDiceRoll+=randomNumber;
        while (randomNumber == maxValue && numberOfRolls < maxRolls){
            randomNumber = getRandomNumber();
            oneDiceRoll+=randomNumber;
            numberOfRolls++;
        }
        if(numberOfRolls == maxRolls && randomNumber == maxValue){
            return 0;
        }
        return oneDiceRoll;
    }

    private int getRandomNumber(){
        return (int)Math.floor(Math.random() * maxValue + 1);
    }
}
