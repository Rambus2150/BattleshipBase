package edu.utep.cs.cs4330.battleship;

/**
 * Created by Ramon Bustamante+ on 2/14/2017.
 */

public class Place {
    int x_coord;
    int y_coord;
    boolean hit=false;
    boolean ship=false;
    public Place( int i, int j){

        this.x_coord=i;
        this.y_coord=j;
        this.hit=false;
        this.ship=false;
    }
    public void hasShip(){
       this.ship=true;
    }
    public void setShip(){
        this.ship=true;
    }
   public boolean placeHit(int x, int y){
        this.hit=true;
        if (this.ship){
           return true;
        }
        return false;
    }
}
