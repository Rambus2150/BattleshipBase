package edu.utep.cs.cs4330.battleship;
/** created by Ramon Bustamante */

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


//AppCompatActivity
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Board board = new Board(10);
    private BoardView boardView;
    private Board  playerBoard = new Board(10);;
    private BoardView playerBoardView;
    Button newbutton;
    Button placeShips;


    Fleet newFleet= new Fleet(board);
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newbutton = (Button) findViewById(R.id.newButton);
        newbutton.setOnClickListener(MainActivity.this);
        text=(TextView)findViewById(R.id.shotCount);

        boardView = (BoardView) findViewById(R.id.boardView);
        boardView.setBoard(board);

        playerBoardView = (BoardView) findViewById(R.id.boardView2);
        playerBoardView.setBoard(playerBoard);

        boardView.addBoardTouchListener(new BoardView.BoardTouchListener() {
            @Override
            public void onTouch(int x, int y) {


                int shots=board.numofShots();



               if( (!board.getHit(x,y).hit)&&board.hit(newFleet,x,y)){
                    board.gamecounter++;
                   board.setHit(x,y);
                    toast(String.format("Hit: %d, %d", x, y));
                   board.addshots();
                   }
               else if(board.isGameover()){

                    toast("All ships sunk play again");
                   newFleet.resetSunk();
                    }
               else if(!board.getHit(x,y).hit){
                   board.setHit(x,y);
                   board.addshots();
                   toast(String.format("Missed: %d, %d", x, y));
                   //board.setMiss(x,y);
               }
                text.setText("number of shots"+shots);
            }
        });
    }

    public void onClick(View v){
        toast(String.format("New Game Started"));
        board.resetShots();
         newFleet= new Fleet(board);
    }


    /** Show a toast message. */
    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
