/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class ClimberBase extends Subsystem {
  private double slideSpeed = 1;
  private double winchSpeed = 0.75;

  private WPI_VictorSPX sliderMotor;
  private WPI_VictorSPX winchMotor;

  public void init(){
    sliderMotor = new WPI_VictorSPX(19);
    winchMotor = new WPI_VictorSPX(18);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }


  public void SlideUp(){
    sliderMotor.set(slideSpeed);
  }

  public void SlideDown(){
    sliderMotor.set(-slideSpeed);
  }

  public void StopSlide(){
    sliderMotor.set(0);
  }

  public void WinchUp(){
    winchMotor.set(winchSpeed);
  }

  public void WinchDown(){
    winchMotor.set(-winchSpeed);
  }

  public void StopWinch(){
    winchMotor.set(0);
  }
}
