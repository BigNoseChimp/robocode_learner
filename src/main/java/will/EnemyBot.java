package will;

import robocode.ScannedRobotEvent;

/**
 * Created by admin on 05/03/18.
 */
public class EnemyBot {

    private double bearing;
    private double distance;
    private double energy;
    private double heading;
    private String name;
    private double velocity;

    public EnemyBot() {
        reset();
    }

    public double getBearing() {
        return bearing;
    }

    public double getDistance() {
        return distance;
    }

    public double getEnergy() {
        return energy;
    }

    public double getHeading() {
        return heading;
    }

    public String getName() {
        return name;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setBearing(double bearing) {
        this.bearing = bearing;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public void setHeading(double heading) {
        this.heading = heading;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void update(ScannedRobotEvent e) {
        bearing = e.getBearing();
        energy = e.getEnergy();
        distance = e.getDistance();
        heading = e.getHeading();
        name = e.getName();
        velocity = e.getVelocity();
    }

    public void reset() {
        name = "";
        bearing = 0.0;
        energy = 0.0;
        distance = 0.0;
        heading = 0.0;
        velocity = 0.0;
    }

    public boolean none() {
        return name.isEmpty();
    }


}
