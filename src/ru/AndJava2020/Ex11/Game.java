package ru.AndJava2020.Ex11;

import javafx.scene.text.Text;

import java.awt.*;
import java.util.Random;

public class Game {
    private int answer;
    private int val;
    public Game(){
        Random rnd=new Random();
        answer=rnd.nextInt(20);//число от 0 до 20

    }
    public boolean tryGuess(int ans, Text hint){
        if(ans==answer) {
            System.out.println("WIN");
            hint.setText("Congratz");
            return true;
        }
        val++;
        if(ans>answer) {
            hint.setText("Number is smaller\n" + (2-val)+" attempts left");
            return false;
        }
        if(ans<answer) {
            hint.setText("Number is bigger\n" + (2-val)+" attempts left");
            return false;
        }
        return false;
    }
    public int getValue() {
        return val;
    }
}
