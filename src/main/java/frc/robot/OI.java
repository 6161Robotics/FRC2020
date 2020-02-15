/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import frc.robot.Gamepad;
//import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Gamepad;
//import frc.robot.commands.*;

public class OI {
  public Joystick theXbox;

  public OI (){
    theXbox = new Joystick(0);
  }

  public Joystick getTheJoystick() {
    return theXbox;
  }

}
