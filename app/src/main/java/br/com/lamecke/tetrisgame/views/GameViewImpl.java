package br.com.lamecke.tetrisgame.views;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.lamecke.tetrisgame.presenters.GameStatus;
import br.com.lamecke.tetrisgame.presenters.GameView;
import br.com.lamecke.tetrisgame.presenters.Point;

public class GameViewImpl implements GameView {

    private final GameFrame mGameframe;
    private final TextView mGameScoreText;
    private final TextView mGameStatusText;
    private final Button mGameCtlBtn;

    public GameViewImpl(GameFrame gameFrame, TextView gameScoreText, TextView gameStatusText,
    Button gameCtlBtn){
        mGameframe = gameFrame;
        mGameScoreText = gameScoreText;
        mGameStatusText = gameStatusText;
        mGameCtlBtn = gameCtlBtn;

    }


    @Override
    public void init(int gameSize) {
        mGameframe.init(gameSize);

    }

    @Override
    public void draw(Point[][] points) {
            mGameframe.setPoints(points);
            mGameframe.invalidate();

    }

    @Override
    public void setScore(int score) {

        mGameScoreText.setText("Score " + score);
    }

    @Override
    public void setStatus(GameStatus gameStatus) {
        mGameStatusText.setText(gameStatus.getValue());
        mGameStatusText.setVisibility(gameStatus == GameStatus.PLAYING ?
                View.INVISIBLE : View.VISIBLE);
        mGameCtlBtn.setText(gameStatus == GameStatus.PLAYING ? "Pause" : "Start");

    }
}
