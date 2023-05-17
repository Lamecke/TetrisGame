package br.com.lamecke.tetrisgame.presenters;

public interface GameModel {
    int FPS = 60;

    int SPEED = 25;
    void init();
    int getGameSize();
    void newGame();
    void startGame(PresentersObserver<Point[][]> onGameDrawListener);
    void gamePause();
    void turn(GameTurn turn);
    void setGameOverListener(PresentersCompletableObserver onGameOverListener);
    void setScoreUpdateListener(PresentersObserver<Integer> onScoreUpdateListener);

}
