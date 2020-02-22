/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AxisButton extends Button {    private final GenericHID m_joystick;
    private final int m_axisNumber;
    private double _threshold;

    public AxisButton(GenericHID joystick, int axisNumber, double threshold) {
        this.m_joystick = joystick;
        this.m_axisNumber = axisNumber;
        _threshold = threshold;
    }

    public boolean get() {
        SmartDashboard.putNumber("OI/Axis/" + m_axisNumber, this.m_joystick.getRawAxis(this.m_axisNumber));
        return this.m_joystick.getRawAxis(this.m_axisNumber) > _threshold;
    }


}