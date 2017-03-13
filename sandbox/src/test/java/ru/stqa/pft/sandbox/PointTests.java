package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Федор on 13.03.2017.
 */
public class PointTests {

  @Test
  public void testDistanceToPointOnAxisX(){
    Point p1 = new Point(0, 0);
    Point p2 = new Point (1, 0);

    Assert.assertEquals(p1.distanceTo(p2), 1.0);
  }

  @Test
  public void testDistanceToPointOnAxisY(){
    Point p1 = new Point(0, 0);
    Point p2 = new Point (0, 10);

    Assert.assertEquals(p1.distanceTo(p2), 10.0);
  }

  @Test
  public void testDistanceTo(){
    Point p1 = new Point(0, 0);
    Point p2 = new Point (-4, -3);

    Assert.assertEquals(p1.distanceTo(p2), 5.0);
  }
}
