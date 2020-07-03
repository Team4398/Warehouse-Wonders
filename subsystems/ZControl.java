/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ZControl extends SubsystemBase {
  /**
   * Creates a new ZControl.
   */
  private WPI_VictorSPX zMotor1; 
  public ZControl() {
    zMotor1 = new WPI_VictorSPX(Constants.zMotor1); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void stop() {
  zMotor1.set(0);
  
}

public void run(double speed) {
  zMotor1.set(speed);
}
}
