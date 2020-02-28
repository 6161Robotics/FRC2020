
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.*;
import edu.wpi.first.wpilibj.Timer;


public class DriveBase extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX driveBaseRightFront;
  private WPI_TalonSRX driveBaseRightRear;
  private WPI_TalonSRX driveBaseLeftFront;
  private WPI_TalonSRX driveBaseLeftRear;
  private DifferentialDrive driveBaseThe4Motors;

  public double autoSpeed = 0.75;
  public double lastForward = 0.25;
  public double curve = 0.07;


  public void init(){
    driveBaseRightFront = new WPI_TalonSRX(16);          
    driveBaseRightRear = new WPI_TalonSRX(15);
    driveBaseLeftFront = new WPI_TalonSRX(13);
    driveBaseLeftRear = new WPI_TalonSRX(14);
   
    SpeedControllerGroup rightSpeedController = new SpeedControllerGroup(driveBaseRightFront, driveBaseRightRear);    
    SpeedControllerGroup leftSpeedController = new SpeedControllerGroup(driveBaseLeftFront, driveBaseLeftRear);
 
    driveBaseThe4Motors = new DifferentialDrive(leftSpeedController, rightSpeedController);
    leftSpeedController.setInverted(true);
    rightSpeedController.setInverted(true);
    
    driveBaseThe4Motors.setSafetyEnabled(false);
    driveBaseThe4Motors.setExpiration(0.1);//0.1 default
    driveBaseThe4Motors.setMaxOutput(1);      


	}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }


  public DifferentialDrive getRobotDrive(){
    return driveBaseThe4Motors;
  }


  public void drivewithXbox(){
    if (Robot.oi.getTheJoystick().getRawButton(3)){
      Robot.driveBase.getRobotDrive().arcadeDrive(-Robot.oi.theXbox.getRawAxis(1), Robot.oi.theXbox.getRawAxis(4));
      return;
    }
    if (Robot.oi.theXbox.getRawAxis(1) > lastForward) {
    	lastForward += curve;
    	//lastForward = lastForward + 0.02; <--- same as above
  	}
    else {
    	lastForward -= curve;
    }
    Robot.driveBase.getRobotDrive().arcadeDrive(-lastForward, -Robot.oi.theXbox.getRawAxis(4));
  }

  public void vibXbox(){
    

   if (Timer.getMatchTime() < 50 && Timer.getMatchTime() > 45){
    Robot.oi.theXbox.setRumble(RumbleType.kLeftRumble, 1);
    Robot.oi.theXbox.setRumble(RumbleType.kRightRumble, 1);
  }

   else {
    Robot.oi.theXbox.setRumble(RumbleType.kLeftRumble, 0);
    Robot.oi.theXbox.setRumble(RumbleType.kRightRumble, 0);
   }
  }
}
