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
import frc.robot.commands.*;

public class OI {
  public Joystick theXbox;
  public JoystickButton joyIntake;
  public JoystickButton joySlideUp;
  public JoystickButton joySlideDown;


  public OI (){
    theXbox = new Joystick(0);

    joyIntake = new JoystickButton(theXbox, 8);
    joyIntake.whileHeld(new Intake());

    joySlideUp = new JoystickButton(theXbox, 4);
    joySlideUp.whileHeld(new SlideUp());

    joySlideDown = new JoystickButton(theXbox, 3);
    joySlideDown.whileHeld(new SlideDown());
  }

  public Joystick getTheJoystick() {
    return theXbox;
  }

}
