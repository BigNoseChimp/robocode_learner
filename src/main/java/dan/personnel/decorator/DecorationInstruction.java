package dan.personnel.decorator;

import java.awt.*;

/**
 * Created by dan.wink on 01 March, 2018
 */
public class DecorationInstruction {

    Color bodyColor ;
    Color gunColor ;
    Color radarColor ;
    Color scanColor ;
    Color bulletColor;

    public DecorationInstruction(Color bodyColor, Color gunColor, Color radarColor, Color scanColor, Color bulletColor) {
        this.bodyColor = bodyColor;
        this.gunColor = gunColor;
        this.radarColor = radarColor;
        this.scanColor = scanColor;
        this.bulletColor = bulletColor;
    }

    public Color getBodyColor() {
        return bodyColor;
    }

    public Color getGunColor() {
        return gunColor;
    }

    public Color getRadarColor() {
        return radarColor;
    }

    public Color getScanColor() {
        return scanColor;
    }

    public Color getBulletColor() {
        return bulletColor;
    }
}