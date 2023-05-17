package br.com.lamecke.tetrisgame.presenters;

public class Point {
    public final int x, y;
    public  Boolean isFallingPoint;
    public PointType type;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.type = PointType.EMPTY;
        this.isFallingPoint = false;
    }

    public Point(int x, int y, PointType type, Boolean isFallingPoint){

        this.x = x;
        this.y =y;
        this.type = type;
        this.isFallingPoint = isFallingPoint;
    }

    public Boolean isStablePoint(){

            return  !this.isFallingPoint && this.type == PointType.BOX;
    }
}
