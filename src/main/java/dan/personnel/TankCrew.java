package dan.personnel;

/**
 * Created by dan.wink on 01 March, 2018
 */
public interface TankCrew<T,U> {

    enum ROLE { DECORATOR, NAVIGATOR, GUNNER, SAFETY_OFFICER }

    // true when crew has a command to make
    boolean hasInstruction();

    // The instruction to the TankController that is relevant to the TankCrew type.
    T getInstruction();

    void update(U update);
}