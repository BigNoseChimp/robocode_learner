package dan.personnel.navigator;

/**
 * Created by dan.wink on 01 March, 2018
 */
public class NavigationInstruction {

    float bearing;
    float distance;

    public NavigationInstruction(float bearing, float distance) {
        this.bearing = bearing;
        this.distance = distance;
    }

    public float getBearing() {
        return bearing;
    }

    public float getDistance() {
        return distance;
    }
}