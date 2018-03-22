package dan.personnel.decorator;

import dan.personnel.TankCrew;

/**
 * Created by dan.wink on 01 March, 2018
 */
public interface Decorator extends TankCrew<DecorationInstruction, DecoratorUpdate> {
}