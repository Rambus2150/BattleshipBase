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

    private Board board;
    private BoardView boardView;
    private Board playerBoard;
    private BoardView playerBoardView;
    Button newbutton;
    Fleet newFleet= new Fleet(true);
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = new Board(10);
        playerBoard = new Board(10);

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
               Board.setX(x);
               Board.setY(y);

                int shots=board.numofShots();

                text.setText("number of shots"+shots);

               if( board.hit(newFleet,x,y)){

                toast(String.format("Hit: %d, %d", x, y));
               // Place hitplace= new Place(x,y);
                   }
                else if(newFleet.isGameover()){

                    toast(String.format("All ships sunk play again"));
                   newFleet.resetSunk();
                }
                else{
                   toast(String.format("Missed: %d, %d", x, y));
                   board.setMiss(x,y);
               }
            }
        });
    }

    public void onClick(View v){
        toast(String.format("New Game Started"));
        board.resetShots();
         newFleet= new Fleet(true);
    }


    /** Show a toast message. */
    protected void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
