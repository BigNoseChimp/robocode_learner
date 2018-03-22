package dan.personnel;

/**
 * Created by dan.wink on 01 March, 2018
 */
public interface TankCrew<T,U> {

    enum ROLE { DECORATOR, NAVIGATOR, GUNNER, SAFETY_OFFICER }

    /**
     * TRUE when crew has a command to give
     */
    boolean hasInstruction();

    /**
     * The instruction to the TankController that is relevant to the TankCrew type.
     * When this method is called, the implementation of tankCrew should assume that
     * the commander has received the instruction (and therefore hasInstruction should
     * return FALSE until there's a new instruction to make)
     */
    T getInstruction();

    /**
     * This method is called periodically to update the tank crew member on
     * tank status information that is relevant to that member.
     * @param update
     */
    void update(U update);
}