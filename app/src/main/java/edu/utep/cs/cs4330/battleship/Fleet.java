package edu.utep.cs.cs4330.battleship;

/**
 * Created by Ramon Bustamante on 2/15/2017.
 */

public class Fleet {
    Ship[] fleet;
 //  static boolean gameover=false;
    int sizeFleet=5;
    static int sunk=0;
    public Fleet(){
        fleet=new Ship[sizeFleet];
        fleet[0]= new Ship(5);
        fleet[1]=new Ship(4);
        fleet[2]=new Ship(3);
        fleet[3]=new Ship(3);
        fleet[4]=new Ship(2);
        createFleet();

    }
    public Fleet(Board boardCom){
        fleet=new Ship[sizeFleet];
        fleet[0]= new Ship(5);
        fleet[1]=new Ship(4);
        fleet[2]=new Ship(3);
        fleet[3]=new Ship(3);
        fleet[4]=new Ship(2);
        createFleetAI(boardCom);
    }
   /* public static void setGameover(){
        gameover=true;
    }*/
   /* public boolean isGameover(){
        return gameover;
    }*/
    public void createFleet(){
        fleet[0].setName("carrier");
        fleet[1].setName("battleship");
        fleet[2].setName("frigate");
        fleet[3].setName("submarine");
        fleet[4].setName("minesweeper");
    }
    public void createFleetAI(Board board){
        fleet[0].setName("carrier");
        fleet[1].setName("battleship");
        fleet[2].setName("frigate");
        fleet[3].setName("submarine");
        fleet[4].setName("minesweeper");

        for(int i=0; i<fleet.length; i++){
           board.setShips(fleet[i]);
        }
    }
    public int getSizeFleet(){
        return this.sizeFleet;
    }
    public static void addSunk(){
        sunk++;
    }
    public static int getSunk(){
        return sunk;
    }
    public static void resetSunk(){
        sunk=0;
    }

}
