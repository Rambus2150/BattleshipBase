package edu.utep.cs.cs4330.battleship;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {
    private static Board  playerBoard = new Board(10);
    private BoardView playerBoardView;
    Fleet playerFleet;
    private RadioGroup rgroup;
    private RadioButton shipselect;
    private RadioGroup sgroup;
    private RadioButton stratSelect;
    Boolean vertical = true;
    Boolean shipSelected=false;
    String shipName;
    Ship selectedship;
    /**
     * 1            2       3   4     5
     * aricraft battleship frig sub mine
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        defineButtons();
        playerBoardView = (BoardView) findViewById(R.id.boardView2);
        playerBoardView.setBoard(playerBoard);
        playerBoardView.player=true;
        playerFleet = new Fleet();
        rgroup=(RadioGroup) findViewById(R.id.rgroup);
        sgroup=(RadioGroup) findViewById(R.id.sgroup);
        playerBoardView.addBoardTouchListener(new BoardView.BoardTouchListener() {

            @Override
            public void onTouch(int x, int y) {

                if(vertical==true&&shipSelected&& y<=10-selectedship.size()){
                    selectedship.setVertical(vertical);
                    playerBoard.setXy(selectedship,x,y);
                    playerBoardView.update();
                }
                else if(vertical==false &&shipSelected&& x<=10-selectedship.size()){
                    selectedship.setVertical(vertical);
                    playerBoard.setXy(selectedship,x,y);
                    playerBoardView.update();


                }
            }
        });

    }
    private View.OnClickListener buttonClickListener=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.randomButton:
                    clear();
                    playerFleet=new Fleet(playerBoard);
                    playerBoardView.update();

                    break;
                case R.id.clearButton:
                    playerFleet=new Fleet();
                    clear();
                    break;
                case R.id.startButton:
                    MainActivity.setStart();
                    finish();
                    break;
                case R.id.orientation:
                    vertical =(!vertical);
                    break;
            }
        }
    };
    public void  defineButtons(){
        findViewById(R.id.randomButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.clearButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.startButton).setOnClickListener(buttonClickListener);
        findViewById(R.id.orientation).setOnClickListener(buttonClickListener);


    }
    public void shipSelect(View v){
        int radioButtonId= rgroup.getCheckedRadioButtonId();
        shipselect=(RadioButton) findViewById(radioButtonId);
        shipSelected = true;
        shipName = (String)shipselect.getText();
        switch(shipName){
            case "Aircraft Carrier":
                selectedship =playerFleet.fleet[0];
                break;
            case "Battleship":
                selectedship =playerFleet.fleet[1];
                break;
            case "Frigate":
                selectedship =playerFleet.fleet[2];
                break;
            case "Submarine":
                selectedship =playerFleet.fleet[3];
                break;
            case "Minesweeper":
                selectedship = playerFleet.fleet[4];
                break;

        }
        Log.d("ID",""+shipName);

        Toast.makeText(getBaseContext(),shipselect.getText(),Toast.LENGTH_LONG).show();
    }
    public void strategySelect(View V){
        int radioButtonId= sgroup.getCheckedRadioButtonId();
        stratSelect=(RadioButton) findViewById(radioButtonId);
        Toast.makeText(getBaseContext(),stratSelect.getText(),Toast.LENGTH_LONG).show();
        String stratName=(String) stratSelect.getText();
        switch(stratName){
            case "Random":
                GameLogic.strategy=1;
                break;
            case "Sweep":
                GameLogic.strategy=2;
                break;
            case "Smart":
                GameLogic.strategy=3;
                break;
        }
    }
    public void setName(String name){
        shipName = name;
    }
    public void clear(){

        playerBoard =new Board(10);
        playerBoardView.setBoard(playerBoard);
        playerFleet= new Fleet();
        playerBoardView.update();

    }
    public static Board  getBoard(){
        return playerBoard;
    }

}