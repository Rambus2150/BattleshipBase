package edu.utep.cs.cs4330.battleship;

import android.util.Log;


/**
 * Created by Ramon Bustamante on 2/13/2017.
 * this class will set the ai ships randomly similar to the hw1
 */

public class Ship {
    public boolean sunk;
    private int size;
    private Place[] xy;
    private boolean vertical;
    private String name;
    private int shipHealth;

    public Ship(int size) {
        this.sunk = false;
        this.size = size;
        //  this.vertical=true;
        //will consist of
        this.xy = new Place[size];
        this.name = "";
        this.shipHealth = 0;
    }

    public Place[] getPlace() {
        return xy;
    }

    public int getshipHealth() {

        return this.shipHealth;
    }

    public static void addshipHealth(Ship type) {

        type.shipHealth++;
        sunk(type);

    }

    public static void sunk(Ship type) {
        if (type.getshipHealth() >= type.size()) {
            type.sunk = true;
            Log.d("SUNK",""+getName(type));
           // Fleet.addSunk();
          //  Board.isGameover();
        }

    }


/**Setting ships sizes and their orientations**/
    /**
     * creates random generated positioning
     **/

    //places player ships needs be called when ships are placed on the drag and drop
    public static void setPLShips( Ship type,boolean dir, int x, int y){
        type.vertical = dir;
     //   setXy(type,x,y);

    }
    //places ai ships


    /**
     * Return the size of this ship.
     */
    public int size() {
        return size;
    }

    public boolean getVertical(){
        return this.vertical;
    }
    public void setVertical( boolean ori) {
        this.vertical = ori;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(Ship type) {

        return type.name;

    }

    /**
     * public boolean isSunk(){
     * boolean sunken = this.sunk;
     * if(sunken){
     * <p>
     * }
     * return sunken;
     * }
     */


   

}