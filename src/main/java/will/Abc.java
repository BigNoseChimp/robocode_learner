package will;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

import java.awt.*;

public class Abc extends AdvancedRobot {

    private AdvancedEnemyBot enemy = new AdvancedEnemyBot();
    static double prevEnergy = 100.0;
    boolean movingForward = true;

    public void run() {
        setBodyColor(Color.red);
        setGunColor(Color.black);
        setRadarColor(Color.orange);
        setBulletColor(Color.cyan);
        setScanColor(Color.cyan);

        setAdjustGunForRobotTurn(true);
        setAdjustRadarForGunTurn(true);



    setTurnRadarRight(Double.POSITIVE_INFINITY);

    }

    double absoluteBearing(double x1, double y1, double x2, double y2){
        double xo = x2 - x1;
        double yo = y2 - y1;
        double theta = Math.atan2(xo, yo);
        double bearing = Math.toDegrees(theta);

        return bearing;
    }

    public void onScannedRobot(ScannedRobotEvent e){

        double firePower = Math.min(500 / enemy.getDistance(), 3);
        double bulletSpeed = 20 - firePower * 3;
        long time = (long)(enemy.getDistance()/bulletSpeed);
        double futureX = enemy.getFutureX(time);
        double futureY = enemy.getFutureY(time);
        double absDeg = absoluteBearing(getX(),getY(), futureX, futureY);


        setTurnGunRight(normalizeBearing(absDeg - getGunHeading()));
        setTurnRadarRight(2.0 * Utils.normalRelativeAngleDegrees(getHeading() + e.getBearing() - getRadarHeading()));
        setTurnRight(e.getBearing() + 90);
        if(getDistanceRemaining()==0.0){
            if (Math.signum(prevEnergy - e.getEnergy())== 1){
                reverseDirection();
            }
            if (getGunHeat() == 0 && Math.abs(getGunTurnRemaining()) < 10)
                setFire(400/e.getDistance());
        }

        prevEnergy = e.getEnergy();

        if(enemy.none() || e.getDistance() < enemy.getDistance() - 70 || e.getName().equals(enemy.getName())){
            enemy.update(e, this);
        }
    }

    double normalizeBearing(double angle){
        while(angle > 180) angle -= 360;
        while (angle < -180) angle += 360;
        return angle;
    }

    public void reverseDirection() {
        if (movingForward) {
            setBack(70);
            movingForward = false;
        } else {
            setAhead(70);
            movingForward = true;
        }
    }
}
