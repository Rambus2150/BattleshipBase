package edu.utep.cs.cs4330.battleship;

/**
 * Created by Ramon Bustamante on 2/28/2017.
 */

public class GameLogic {
   static int strategy;
    static int x=0;
    static int y=0;

    public static void makeComputerShot(Board board){
        Strategy();
        if(!board.isGameover()&&!board.getHit(x,y).hit){
            board.getHit(x,y).hit=true;
        }
        else{
            makeComputerShot(board);
        }
    }
    public static void Strategy(){
        //implement random Strategy
        if(strategy==1){
                 x = 0 + (int) (Math.random() * 9);
                 y = 0 + (int) (Math.random() * 9);
        }

        //implement sweep strategy
        else if(strategy==2){
            if(x>=9){
                x=0;
                y++;
            }
            x++;
            if(y>=9){
                y=0;
            }

        }
        else if(strategy==3){
            x = 0 + (int) (Math.random() * 9);
            y = 0 + (int) (Math.random() * 9);
        }
    }
}
