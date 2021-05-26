package practice.harish.designpatterns.factorymethod;

public class Point {

    private double x,y;

    /**
     *
     * @param a
     * @param b
     * @param cs
     */
    public Point(double a, double b, CoordinateSystem cs) {
        switch (cs) {
            case CARTESIAN:
                this.x = a;
                this.y = b;
                break;
            case POLAR:
                x = a * Math.cos(b);
                y = a * Math.sin(b);
                break;
        }
    }


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x, double y) {
        return new Point(x,y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
    }


}
