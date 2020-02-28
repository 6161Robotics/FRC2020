/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallBase extends Subsystem {
  private double intakeSpeed = 0.5;
  private double conveyorSpeed = 1;
  private double shooterSpeed = 0.33;
  private WPI_VictorSPX intakeMotor;
  private WPI_VictorSPX conveyorMotor;
  private WPI_VictorSPX shooterMotor;
  
  
  public void init(){
  intakeMotor = new WPI_VictorSPX(12);
  conveyorMotor = new WPI_VictorSPX(17);
  shooterMotor = new WPI_VictorSPX(10);
  
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Intake(){
    intakeMotor.set(-intakeSpeed);
  }
  public void Outtake(){
    intakeMotor.set(intakeSpeed);
  }

  public void Convey(){
    conveyorMotor.set(conveyorSpeed);
  }
       
  public void StopConvey(){     
    conveyorMotor.set(0);
  }

  public void Shoot(){ 
    shooterMotor.set(shooterSpeed);
  }

  public void StopShoot(){
    shooterMotor.set(0);
  }

  public void StopIntake(){
    intakeMotor.set(0);
  }

}
