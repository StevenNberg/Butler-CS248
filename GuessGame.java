/* Steven Nirenberg
    The Guessing Game */

import java.io.*;
import java.util.*;
import java.math.*;

class GuessGame{
    static int Rand(){
        int randomNumber=(int)(1+100*Math.random());
        return randomNumber;
    }

    static String insults(){
        String [] insultList=new String [5];
        insultList[0]="You're not as dumb as people say. You're a whole lot worse";
        insultList[1]="I don't think you're dumb. You just have bad luck when it comes to thinking";
        insultList[2]="Brains are't everything. In your casem they're nothing";
        insultList[3]="*sigh*";
        insultList[4]="There's smoke coming from your ears. You must be trying to think";

        int randomInsult=(int)(1+5*Math.random());
        return insultList[randomInsult-1];
    }
    public static void main (String [] args){
        int randomNumber=Rand();
        int userNumber=0;
        Scanner cin=new Scanner(System.in);
        int continueGame;
        System.out.println("If you would like to play, enter '0'. If not, enter in '-1'");
        continueGame=cin.nextInt();
        if(continueGame==0)
            userNumber=0;
        else if(continueGame==-1)
            userNumber=-1;
        while(userNumber!=-1){
            System.out.print("What is your guess? ");
            userNumber=cin.nextInt();
            if(userNumber>randomNumber){
                System.out.println("Too high!");
                System.out.println(insults());
            }
            else if(userNumber<randomNumber){
                System.out.println("Too low!");
                System.out.println(insults());
            }
            else if(userNumber==randomNumber){
                System.out.println("Congrats!");
                userNumber=-1;
                System.out.println("If you would like to play again, enter '0'. If not, enter in '-1'");
                continueGame=cin.nextInt();
                if(continueGame==0){
                    userNumber=0;
                    randomNumber=Rand();
                }
                else if(continueGame==-1){
                    userNumber=-1;
                    System.out.println("Fine be that way!. Don't ever come back!");
                }
            }
        }

    }
}