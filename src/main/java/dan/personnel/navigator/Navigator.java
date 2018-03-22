package dan.personnel.navigator;

import dan.personnel.TankCrew;

/**
 * Created by dan.wink on 01 March, 2018
 */
public interface Navigator extends TankCrew<NavigationInstruction, NavigatorUpdate> {

    void plotRoute(NavigationRequest... routePoints);
    void currentNavigationStatus(NavigatorUpdate navStatus);
}