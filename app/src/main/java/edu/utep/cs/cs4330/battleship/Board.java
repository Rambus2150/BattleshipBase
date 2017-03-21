package edu.utep.cs.cs4330.battleship;

/**
 * A game board consisting of <code>size</code> * <code>size</code> places
 * where battleships can be placed. A place of the board is denoted
 * by a pair of 0-based indices (x, y), where x is a column index
 * and y is a row index. A place of the board can be shot at, resulting
 * in either a hit or miss.
 */
public class Board {
    int shots=0;
   static int j;
    static int k;
    static int [][] hitBoard;
    /**
     * Size of this board. This board has
     * <code>size*size </code> places.
     */
    private final int size;

    /** Create a new board of the given size. */
    public Board(int size) {
        this.size = size;
        this.hitBoard=new int[size][size];
    }

    /** Return the size of this board. */
    public int size() {
        return size;
    }

    public boolean hit(Fleet ships,int x, int y){

        int size=ships.getSizeFleet();

        for(int i=0; i<size;i++){
            for(int j=0;j<ships.fleet[i].size();j++) {
                if (ships.fleet[i].getPlace()[j].x_coord== x
                        && ships.fleet[i].getPlace()[j].y_coord== y) {
                   Ship.addshipHealth(ships.fleet[i]);// ships.fleet[i].addshipHealth();
                    setHit(x,y);

                    return true;
                }
            }
        }
            setMiss(x,y);
            return false;

    }
    public void setHit(int x, int y) {
       this.hitBoard[x][y]=1;
    }
    public void setMiss(int x, int y){
        this.hitBoard[x][y]=2;
    }
    public int getHit(int x, int y){
        return this.hitBoard[x][y];
    }
    public int numofShots(){
        return shots++;
    }
    public void resetShots(){
        shots=0;
    }
    public static void setX(int x){
        j=x;
    }
    public static void setY(int y){
        k=y;
    }


    // Suggestions:
    // 1. Consider using the Observer design pattern so that a client,
    //    say a BoardView, can observe changes on a board, e.g.,
    //    hitting a place, sinking a ship, and game over.
    //
    // 2. Introduce methods including the following:
    //    public boolean placeShip(Ship ship, int x, int y, boolean dir)
    //    public void hit(Place place)
    //    public Place at(int x, int y)
    //    public Place[] places()
    //    public int numOfShots()
    //    public boolean isGameOver()
    //    ...

}
