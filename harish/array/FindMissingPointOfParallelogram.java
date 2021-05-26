package practice.harish.array;

import java.util.ArrayList;
import java.util.List;

public class FindMissingPointOfParallelogram {


    public static void main(String[] args) {
        Point pointA = new Point(1, 2);
        Point pointB = new Point(2, 3);
        Point pointC = new Point(0, 4);
        Point pointD = new Point();

        //Find the length between A and C
        // The length between B and D will be same as this
        float length = findDistanceBetweenTwoPoints(pointA, pointC);
        float slope = (float) findSlope(pointA, pointC);
        // So now we have to find the point which is at distance length obtained and have a slope of
        // slope obtained above from point B

        List<Point> pointList = findPoints(pointB, length, slope);
        for (Point point :
                pointList) {
            if (findDistanceBetweenTwoPoints(pointA, pointB) == findDistanceBetweenTwoPoints(pointC, point))
                System.out.println(point.x + " " + point.y);

        }


    }

    public static double findSlope(Point pointA, Point pointC) {
        return (pointC.y - pointA.y) / (pointC.x - pointA.x);
    }

    public static float findDistanceBetweenTwoPoints(Point pointA, Point pointC) {
        return (float) Math.sqrt(Math.pow(pointA.x - pointC.x, 2) + Math.pow(pointA.y - pointC.y, 2));
    }


    /**
     * Given the co-ordinates of a 2-dimensional point p(x0, y0). Find the points at a distance L away from it, such that the
     * line formed by joining these points has a slope of M
     *
     * @param source
     * @param distance
     * @param slope    Examples
     *                 Input : p = (2, 1)
     *                 L = sqrt(2)
     *                 M = 1
     *                 Output :3, 2
     *                 1, 0
     *                 Explanation:
     *                 The two points are sqrt(2) distance away
     *                 from the source and have the required slope
     *                 m = 1.
     *                 <p>
     *                 Input : p = (1, 0)
     *                 L = 5
     *                 M = 0
     *                 Output : 6, 0
     * @return
     */
    public static List<Point> findPoints(Point source, float distance, float slope) {

        ArrayList<Point> points = new ArrayList<>();

        if (slope == 0) {
            points.add(new Point(source.x + distance, source.y));
            points.add(new Point(source.x - distance, source.y));
        } else if (slope == Float.MAX_VALUE) {
            points.add(new Point(source.x, source.y + distance));
            points.add(new Point(source.x, source.y - distance));
        } else {
            float dx = (float) (distance / (Math.sqrt(1 + slope * slope)));
            float dy = slope * dx;
            points.add(new Point(source.x + dx, source.y + dy));
            points.add(new Point(source.x - dx, source.y - dy));
        }
        return points;
    }

}
