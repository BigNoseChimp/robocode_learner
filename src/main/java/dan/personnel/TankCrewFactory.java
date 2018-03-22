package dan.personnel;

import dan.personnel.commander.Commander;
import dan.personnel.commander.CommanderUpdate;
import dan.personnel.decorator.Decorator;
import dan.personnel.decorator.DecoratorUpdate;
import dan.personnel.gunner.Gunner;
import dan.personnel.gunner.GunnerUpdate;
import dan.personnel.navigator.Navigator;
import dan.personnel.navigator.NavigatorUpdate;
import dan.personnel.safetyOfficer.SafetyOfficer;
import dan.personnel.safetyOfficer.SafetyOfficerUpdate;

/**
 * Created by dan.wink on 01 March, 2018
 */
public class TankCrewFactory {

    public static TankCrew<Commander, CommanderUpdate> hireCommander() {
        return null ;
    }

    public static TankCrew<Navigator, NavigatorUpdate> hireNavigator() {
        return null ;
    }

    public static TankCrew<Decorator, DecoratorUpdate> hirePainterAndDecorator() {
        return null;
    }

    public static TankCrew<SafetyOfficer, SafetyOfficerUpdate> hireSafetyOfficer() {
        return null;
    }

    public static TankCrew<Gunner, GunnerUpdate> hireGunner() {
        return null;
    }
}