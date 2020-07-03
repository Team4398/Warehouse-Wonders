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

public class YControl extends SubsystemBase {
  /**
   * Creates a new XControl.
   */
  private WPI_VictorSPX yMotor1; 
  private WPI_VictorSPX yMotor2; 
  public YControl() {
    yMotor1 = new WPI_VictorSPX(Constants.yMotor1); 
    yMotor2 = new WPI_VictorSPX(Constants.yMotor2); 
  }

  public void run(double speed) {
    yMotor1.set(-speed);
    yMotor2.set(speed); 
  }

  public void stop() {
    yMotor1.set(0);
    yMotor2.set(0); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}