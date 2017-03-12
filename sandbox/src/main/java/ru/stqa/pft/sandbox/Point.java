package ru.stqa.pft.sandbox;

public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceTo (Point p){
    double deltaX = this.x - p.x;
    double deltaY = this.y - p.y;
    double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

    return distance;
  }

}
