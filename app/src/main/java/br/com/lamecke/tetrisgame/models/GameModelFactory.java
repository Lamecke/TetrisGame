package br.com.lamecke.tetrisgame.models;

import br.com.lamecke.tetrisgame.presenters.GameModel;

public class GameModelFactory   {
    private GameModelFactory(){

    }
    public static GameModel newGameModel(GameType type){
        switch (type){
            case Tetris:
                return new TetrisGameModel();
            default:
                return null;
        }

    }
}
