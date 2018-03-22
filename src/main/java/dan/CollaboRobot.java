package dan;

import dan.personnel.TankCrew;
import dan.personnel.TankCrewFactory;
import dan.personnel.decorator.DecorationInstruction;
import dan.personnel.decorator.Decorator;
import dan.personnel.decorator.DecoratorUpdate;
import dan.personnel.gunner.Gunner;
import dan.personnel.navigator.NavigationInstruction;
import dan.personnel.navigator.NavigatorUpdate;
import dan.personnel.navigator.Navigator;
import dan.personnel.safetyOfficer.SafetyOfficer;
import dan.personnel.safetyOfficer.SafetyOfficerUpdate;
import robocode.*;

import java.util.HashMap;
import java.util.Map;

import static dan.personnel.TankCrew.ROLE.*;
import static dan.personnel.decorator.DecoratorUpdate.MOOD.*;

/**
 * Created by dan.wink on 01 March, 2018
 */
public class CollaboRobot extends AdvancedRobot {

    final Map<TankCrew.ROLE, TankCrew> tankCrew = new HashMap<TankCrew.ROLE, TankCrew>();

    /**
     * run: Crazy's main run function
     */
    public void run() {

        tankCrew.put(NAVIGATOR, TankCrewFactory.hireNavigator());
        tankCrew.put(DECORATOR, TankCrewFactory.hirePainterAndDecorator());
        tankCrew.put(SAFETY_OFFICER, TankCrewFactory.hireSafetyOfficer());
        tankCrew.put(GUNNER, TankCrewFactory.hireGunner());

        // Loop forever
        while (true) {
            updateCrew() ;
            listenToCrew() ;
        }
    }

    private void updateCrew() {
        for ( TankCrew.ROLE role : tankCrew.keySet() ) {
            switch ( role ) {
                case NAVIGATOR:
                    tankCrew.get(role).update(new NavigatorUpdate(getX(), getY(), getHeading()));
                    break;
                case DECORATOR:
                    tankCrew.get(role).update(new DecoratorUpdate(HAPPY));
                    break;
            }
        }
    }

    private void listenToCrew() {
        for ( TankCrew.ROLE role : tankCrew.keySet() ) {
            switch ( role ) {
                case NAVIGATOR:
                    actOnNavigatorInstruction((Navigator) tankCrew.get(NAVIGATOR));
                    break ;
                case DECORATOR:
                    actOnDecoratorInstuction((Decorator) tankCrew.get(DECORATOR));
                    break ;
                case SAFETY_OFFICER:
                    actOnSafetyOfficerInstruction((SafetyOfficer) tankCrew.get(SAFETY_OFFICER));
                    break ;
                case GUNNER:
                    actOnGunnarInstruction((Gunner) tankCrew.get(GUNNER));
                    break ;
            }
        }
    }

    private void actOnGunnarInstruction(Gunner gunner) {

    }

    private void actOnSafetyOfficerInstruction(SafetyOfficer safetyOfficer) {
        
    }

    private void actOnDecoratorInstuction(Decorator crew) {
        if ( ! crew.hasInstruction() ) {
            return ;
        }
        final DecorationInstruction instruction = crew.getInstruction();
        this.setBodyColor(instruction.getBodyColor());
        this.setBulletColor(instruction.getBulletColor());
        this.setGunColor(instruction.getGunColor());
        this.setRadarColor(instruction.getRadarColor());
        this.setScanColor(instruction.getScanColor());
    }

    private void actOnNavigatorInstruction(Navigator crew) {
        if ( ! crew.hasInstruction() ) {
           return ;
        }
        final NavigationInstruction instruction = crew.getInstruction();
        // negative means it will turn left left
        this.setTurnRight(instruction.getBearing());
        // negative means it will go backwards
        this.setAhead(instruction.getDistance());
    }


    @Override
    public void onHitByBullet(HitByBulletEvent event) {
        if ( tankCrew.containsKey(SAFETY_OFFICER) ) {
            tankCrew.get(SAFETY_OFFICER).update(new SafetyOfficerUpdate());
        }
    }

    public void onStatus(StatusEvent event) {
    }

    public void onBulletHit(BulletHitEvent event) {
    }

    public void onBulletHitBullet(BulletHitBulletEvent event) {
    }

    public void onBulletMissed(BulletMissedEvent event) {
    }

    public void onDeath(DeathEvent event) {
    }

    public void onHitRobot(HitRobotEvent event) {
    }

    public void onHitWall(HitWallEvent event) {
    }

    public void onRobotDeath(RobotDeathEvent event) {
    }

    public void onScannedRobot(ScannedRobotEvent event) {
    }

    public void onWin(WinEvent event) {
    }

    public void onRoundEnded(RoundEndedEvent event) {
    }

    public void onBattleEnded(BattleEndedEvent event) {
    }
}