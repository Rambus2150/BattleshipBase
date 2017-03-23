package edu.utep.cs.cs4330.battleship;

/**
 * A game board consisting of <code>size</code> * <code>size</code> places
 * where battleships can be placed. A place of the board is denoted
 * by a pair of 0-based indices (x, y), where x is a column index
 * and y is a row index. A place of the board can be shot at, resulting
 * in either a hit or miss.
 */
public class Board {
    int shots=1;
    int gamecounter=1;
    private Place [][] hitBoard;
    /**
     * Size of this board. This board has
     * <code>size*size </code> places.
     */
    private final int size;

    /** Create a new board of the given size. */
    public Board(int size) {
        this.size = size;
        this.hitBoard=new Place[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                this.hitBoard[i][j]= new Place(i,j);
            }
        }
    }

    /** Return the size of this board. */
    public int size() {
        return size;
    }

    public boolean hit(Fleet ships,int x, int y){

        int size=ships.getSizeFleet();

        if(this.hitBoard[x][y].ship){

            for(int i=0; i<size;i++){
                for(int j=0;j<ships.fleet[i].size();j++) {
                    if (ships.fleet[i].getPlace()[j].x_coord== x && ships.fleet[i].getPlace()[j].y_coord== y) {
                        Ship.addshipHealth(ships.fleet[i]);// ships.fleet[i].addshipHealth();

                        return true;
                    }
                }
            }
        }


            return false;

    }
    public void setHit(int x, int y) {
      //  gamecounter++;
       this.hitBoard[x][y].hit=true;
    }

   //used for Ai ships
   public  void placeShip(Ship type) {
       int i = type.size() - 1;
       if (type.getVertical()) {
           int x = 0 + (int) (Math.random() * 9);
           int y = 0 + (int) (Math.random() * i);
           setXy(type, x, y);

       } else {
           int x = 0 + (int) (Math.random() * i);
           int y = 0 + (int) (Math.random() * 9);
           setXy(type, x, y);
       }
   }
    public Place getHit(int x, int y){
        return this.hitBoard[x][y];
    }
    public int numofShots(){
        return shots;
    }
    public void addshots(){
        shots++;
    }
    public void resetShots(){
        shots=0;
    }

    public  void setXy(Ship type, int x, int y) {
        int j = type.size();
        if (type.getVertical()) {
            for (int i = 0; i < j; i++) {
                Place coord = new Place(x, y);
                type.getPlace()[i] = coord;
                this.hitBoard[x][y].setShip();
                y++;
            }
        } else {
            for (int i = 0; i < j; i++) {
                Place coord = new Place(x, y);
                type.getPlace()[i] = coord;
                this.hitBoard[x][y].setShip();

                x++;
            }
        }
    }
    public void setShips(Ship type) {
        setOrientation(type);
        placeShip(type);

    }

    public static void setOrientation(Ship type) {
        int random;
        random = 0 + (int) (Math.random() * 2);
        if (random == 1) {
            type.setVertical( false);

        } else type.setVertical( true);
    }

    public boolean isGameover(){
       if(shots==100){
           return true;
       }
       else if(gamecounter==17){
           return true;
       }
        else return false;
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
