package edu.utep.cs.cs4330.battleship;
/** created by Ramon Bustamante */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


//AppCompatActivity
public class MainActivity extends AppCompatActivity {
    boolean playerturn=true;
    private Board board = new Board(10);
    private BoardView boardView;
    private static Board  playerBoard = new Board(10);
    private static BoardView playerBoardView;
    static boolean  start=false;
    Fleet newFleet= new Fleet(board);
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineButtons();


        text=(TextView)findViewById(R.id.shotCount);

        boardView = (BoardView) findViewById(R.id.boardView);
        boardView.setBoard(board);

        playerBoardView = (BoardView) findViewById(R.id.boardView2);
        playerBoardView.setBoard(playerBoard);
        if(start){
            setPlayerBoard();

        }

        boardView.addBoardTouchListener(new BoardView.BoardTouchListener() {
            @Override
            public void onTouch(int x, int y) {


                int shots=board.numofShots();

                if(playerturn) {

                    if ((!board.getHit(x, y).hit) && board.hit(newFleet, x, y)) {
                        board.gamecounter++;
                        board.setHit(x, y);
                        toast(String.format("Hit: %d, %d", x, y));
                        board.addshots();
                    } else if (board.isGameover()) {

                        toast("All ships sunk play again");
                        //newFleet.resetSunk();
                    } else if (!board.getHit(x, y).hit) {
                        board.setHit(x, y);
                        board.addshots();
                        toast(String.format("Missed: %d, %d", x, y));
                        //board.setMiss(x,y);
                    }
                    playerturn=false;
                }

                if(!playerturn) {
                    GameLogic.makeComputerShot(playerBoard);
                    playerturn=true;
                }
                boardView.update();
                playerBoardView.update();
                text.setText("Shots"+shots);

            }
        });
    }
    private View.OnClickListener buttonClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.newButton:

                    toast(String.format("New Game Started"));
                    setPlayerBoard();
                    newgame();
                    break;
                case R.id.placeShips:
                    //starts a new activity
                    toast(String.format("placeShips"));
                    placeActivity(v);
            }
        }
    };
    public void newgame(){
        board.resetShots();
        board =new Board(10);
        boardView.setBoard(board);
        newFleet= new Fleet(board);
        boardView.update();
        playerBoardView.player=true;
        playerBoardView.setBoard(playerBoard);
        playerBoardView.update();

    }
    public void  defineButtons(){
        findViewById(R.id.newButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.placeShips).setOnClickListener(buttonClickListener);
    }

    public void placeActivity(View view){
        Intent startPlayActivity = new Intent(this, PlayActivity.class);
        startActivity(startPlayActivity);
    }

    public void setPlayerBoard(){
        playerBoard = PlayActivity.getBoard();
        playerBoardView.setBoard(playerBoard);
        playerBoardView.update();

    }
    public static void setStart(){
        start = true;
    }
    /** Show a toast message. */
    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
/* */