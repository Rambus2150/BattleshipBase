package edu.utep.cs.cs4330.battleship;

/**
 * Created by Ramon Bustamante on 2/28/2017.
 */

public class GameLogic {
    public void makePlayerShot(Board board, int x, int y){
      //  place.hit();
        if(!board.isGameover()&&!board.getHit(x,y).ship){//miss
          //  changeTurn();
           // new Thread(this::makeComputerShot).start();
            //new thread
        }
    }
    private void makeComputerShot(Board board){
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){}
       // boolean hit =opponent().makeMove();
        if(!board.isGameover()){
           // makeComputerShot();
        }else{
            //changeTurn();
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
    public void changeTurn(boolean playerturn){
        if(playerturn)
        playerturn=false;
        else playerturn=true;
    }
    public void opponent(){}
    public void makeMove(){}

}
