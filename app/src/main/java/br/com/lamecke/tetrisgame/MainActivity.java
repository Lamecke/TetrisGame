package br.com.lamecke.tetrisgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import br.com.lamecke.tetrisgame.models.GameModelFactory;
import br.com.lamecke.tetrisgame.models.GameType;
import br.com.lamecke.tetrisgame.presenters.GamePresenter;
import br.com.lamecke.tetrisgame.presenters.GameTurn;
import br.com.lamecke.tetrisgame.views.GameFrame;
import br.com.lamecke.tetrisgame.views.GameViewFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameFrame gameFrame = findViewById(R.id.game_container);
        TextView gameScoreText = findViewById(R.id.game_score);
        TextView gameStatusText = findViewById(R.id.game_status);
        Button gameCtlBtn = findViewById(R.id.game_ctl_btn);

        GamePresenter gamePresenter = new GamePresenter();
        gamePresenter.setGameModel(GameModelFactory.newGameModel(GameType.Tetris));
        gamePresenter.setGameView(GameViewFactory.newGameView(gameFrame,gameScoreText,
                gameStatusText,gameCtlBtn));

        Button upbtn = findViewById(R.id.up_btn);
        Button downbtn = findViewById(R.id.down_btn);
        Button leftbtn = findViewById(R.id.left_btn);
        Button rightbtn = findViewById(R.id.right_btn);
        Button firebtn = findViewById(R.id.fire_btn);

        upbtn.setOnClickListener( v -> gamePresenter.turn(GameTurn.UP));
        downbtn.setOnClickListener( v -> gamePresenter.turn(GameTurn.DOWN));
        leftbtn.setOnClickListener( v -> gamePresenter.turn(GameTurn.LEFT));
        rightbtn.setOnClickListener( v -> gamePresenter.turn(GameTurn.RIGHT));
        firebtn.setOnClickListener( v -> gamePresenter.turn(GameTurn.FIRE));

        gameCtlBtn.setOnClickListener(v -> gamePresenter.changerStatus());

        gamePresenter.init();

    }
}