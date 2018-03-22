package dan.personnel.navigator;

/**
 * Created by dan.wink on 01 March, 2018
 */
public class NavigationRequest {

    float x ;
    float y ;

    public NavigationRequest(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}