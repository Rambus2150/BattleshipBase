package edu.utep.cs.cs4330.battleship;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {
    private Board  playerBoard = new Board(10);
    private BoardView playerBoardView;
    RadioGroup rgroup;
    RadioButton shipselect;
    RadioGroup sgroup;
    RadioButton stratSelect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        playerBoardView = (BoardView) findViewById(R.id.boardView2);
        playerBoardView.setBoard(playerBoard);
     //   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
        rgroup=(RadioGroup) findViewById(R.id.rgroup);
        sgroup=(RadioGroup) findViewById(R.id.sgroup);
        playerBoardView.addBoardTouchListener(new BoardView.BoardTouchListener() {
            @Override
            public void onTouch(int x, int y) {

            }
//   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        });

    }
    public void shipSelect(View v){
        int radioButtonId= rgroup.getCheckedRadioButtonId();
        shipselect=(RadioButton) findViewById(radioButtonId);
        Toast.makeText(getBaseContext(),shipselect.getText(),Toast.LENGTH_LONG).show();
    }
    public void strategySelect(View V){
        int radioButtonId= sgroup.getCheckedRadioButtonId();
        stratSelect=(RadioButton) findViewById(radioButtonId);
        Toast.makeText(getBaseContext(),stratSelect.getText(),Toast.LENGTH_LONG).show();
    }

}