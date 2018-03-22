package dan.personnel.decorator;

/**
 * Created by dan.wink on 01 March, 2018
 */
public class DecoratorUpdate {

    public enum MOOD { HAPPY, SAD, SNEAKY, LOUD }

    MOOD mood ;

    public DecoratorUpdate(MOOD mood) {
        this.mood = mood;
    }

    public MOOD getMood() {
        return mood;
    }
}