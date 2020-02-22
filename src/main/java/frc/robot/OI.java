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
  public AxisButton joyIntake;
  public AxisButton joyOuttake;
  public JoystickButton joySlideUp;
  public JoystickButton joySlideDown;
  public JoystickButton joyWinchUp;
  public JoystickButton joyWinchDown;
  private double threshhold = 0.2;


  public OI (){
    theXbox = new Joystick(0);

    joyIntake = new AxisButton(theXbox, Gamepad.Axes.RIGHT_TRIGGER.getNumber(), threshhold);
    joyIntake.whileHeld(new Intake());

    joyOuttake = new AxisButton(theXbox, Gamepad.Axes.LEFT_TRIGGER.getNumber(), threshhold);
    joyOuttake.whileHeld(new Outtake());

    joySlideUp = new JoystickButton(theXbox, 4);
    joySlideUp.whileHeld(new SlideUp());

    joySlideDown = new JoystickButton(theXbox, 2);
    joySlideDown.whileHeld(new SlideDown());

    joyWinchUp = new JoystickButton(theXbox, 5);
    joyWinchUp.whileHeld(new WinchUp());

    joyWinchDown = new JoystickButton(theXbox, 6);
    joyWinchDown.whileHeld(new WinchDown());

  }

  public Joystick getTheJoystick() {
    return theXbox;
  }

}
