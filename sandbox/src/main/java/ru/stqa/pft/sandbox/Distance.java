package ru.stqa.pft.sandbox;

public class Distance {

  public static void main(String[] args){

    Point p1 = new Point(0,0);
    Point p2 = new Point(3,4);

    /*
    * Вычисление по функции
    */
    System.out.println("Расстояние между точками p1(" + p1.x + ", " + p1.y + ") и p2(" + p2.x + ", " + p2.y + ") равно " + distance(p1, p2));

    /*
    * Вычисление по методу
    */
    System.out.println("Расстояние от точки p1("+ p1.x + ", " + p1.y + ") до точки p2(" + p2.x + ", " + p2.y + ") равно " + p1.distanceTo(p2));

  }

  public static double distance(Point p1, Point p2){
    double deltaX = p1.x - p2.x;
    double deltaY = p1.y - p2.y;
    double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

    return distance;
  }
}
