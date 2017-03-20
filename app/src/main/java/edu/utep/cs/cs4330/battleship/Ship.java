package edu.utep.cs.cs4330.battleship;

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
        this.sunk=false;
        this.size = size;
      //  this.vertical=true;
        //will consist of
        this.xy = new Place[size];
        this.name="";
        this.shipHealth=0;
    }
    public Place[] getPlace(){
        return xy;
    }
    public int getshipHealth(){

        return this.shipHealth;
    }
    public void addshipHealth(){

        this.shipHealth++;
    }
    public void sunk(){
        if(this.getshipHealth()<=this.size()){
            this.sunk=true;
           Fleet.addSunk();
           isGameover();
        }

    }
    public void isGameover(){
        if(Fleet.getSunk()>=5) {
            Fleet.setGameover();
        }
    }
/**Setting ships sizes and their orientations**/
/** creates random generated positioning**/

    public  static void setShips(Ship type){
        setOrientation(type);
        placeShip(type);

    }
    public static void placeShip(Ship type){
        int i =type.size()-1;
        if(type.vertical) {
            int x = 0 + (int) (Math.random() * 9);
            int y = 0 + (int) (Math.random() * i);
            setXy(type, x,y);
           /*for(int j= 0, j<2, j++;){
                type.xy[j]=
            }*/
        }
        else{
            int x = 0 + (int) (Math.random() * i);
            int y = 0 + (int) (Math.random() * 9);
            setXy(type, x,y);
        }
    }

    public static void setOrientation(Ship type){
        int random;
        random = 0+(int)( Math.random()*1);
        if(random==1){
            setVertical(type,false);

        }
        else setVertical(type,true);
    }

    /** Return the size of this ship. */
    public int size() {
        return size;
    }

    public static void setVertical(Ship type, boolean ori){
        type.vertical=ori;
    }

    public static void setXy(Ship type, int x,int y){
       int j= type.size();
        if(type.vertical) {
            for(int i=0; i<j;i++){
            Place coord = new Place(x, y);
            type.xy[i]=coord;
                y++;
            }
        }
        else{
            for(int i=0; i<j;i++){
                Place coord = new Place(x, y);
                type.xy[i]=coord;
                x++;
            }
        }
    }
    public  void setName(String name){
        this.name=name;
    }
    public String getName(Ship type){
       String name =type.name;
        return name;

    }
    public boolean isSunk(){
        boolean sunken = this.sunk;
        if(sunken){

        }
        return sunken;
    }


}
