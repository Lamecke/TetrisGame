package br.com.lamecke.tetrisgame.presenters;

public class GamePresenter {
    private GameView mGameView;
    private  GameModel mGameModel;
    private GameStatus mGameStatus;

    public void setGameView(GameView gameView){

        mGameView = gameView;
    }
    public void setGameModel(GameModel gameModel){

            mGameModel = gameModel;
    }
    public void init(){
        mGameModel.init();
        mGameView.init(mGameModel.getGameSize());
        mGameModel.setGameOverListener(()-> setStatus(GameStatus.OVER));
        mGameModel.setScoreUpdateListener(mGameView::setScore);
        setStatus(GameStatus.START);

    }
    public void turn(GameTurn turn){
        mGameModel.turn(turn);
    }
    public void changerStatus(){
        if (mGameStatus == GameStatus.PLAYING){
                pausedGame();
        }else {
                startGame();
        }
    }
    private void pausedGame(){
        setStatus(GameStatus.PAUSED);
        mGameModel.gamePause();
    }

    private void startGame(){
        setStatus(GameStatus.PLAYING);
        mGameModel.startGame(mGameView::draw);
    }
    private void setStatus(GameStatus gameStatus){
        if ((mGameStatus == GameStatus.OVER || gameStatus == GameStatus.START)) {
            mGameModel.newGame();
        }
            mGameStatus = gameStatus;
            mGameView.setStatus(gameStatus);


    }
}
