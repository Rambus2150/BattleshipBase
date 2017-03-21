package edu.utep.cs.cs4330.battleship;

/**
 * Created by Ramon Bustamante on 2/28/2017.
 */
/*
public class GameLogic {
    public void makePlayerShot(Place place){
        place.hit();
        if(!Fleet.gameover&&!place.hasShip()){//miss
            changeTurn();
            new Thread(this::makeComputerShot).start();
            //new thread
        }
    }
    private void makeComputerShot(){
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){}
        boolean hit =opponent().makeMove();
        if(!Fleet.gameover){
            makeComputerShot();
        }else{
            changeTurn();
        }
    }
    public void Strategy(int i){
        if(i==1){


                int x = 0 + (int) (Math.random() * 9);
                int y = 0 + (int) (Math.random() * i);

        }
            //implement random Strategy

        else if(i==2){
            //implement sweep strategy
        }
        else if(i==3){
            //implement smart strategy
        }
    }
    public void changeTurn(){
        if(playerTurn)
        playerTurn=false;
        else playerTurn=true;
    }
    public void opponent(){}
    public void makeMove(){}

}
*/