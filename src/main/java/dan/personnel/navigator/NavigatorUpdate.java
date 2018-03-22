package dan.personnel.navigator;

/**
 * Created by dan.wink on 01 March, 2018
 */
public class NavigatorUpdate {
    private double x;
    private double y;
    private double bodyHeading;

    public NavigatorUpdate(double x, double y, double bodyHeading) {
        this.x = x;
        this.y = y;
        this.bodyHeading = bodyHeading;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getBodyHeading() {
        return bodyHeading;
    }
}