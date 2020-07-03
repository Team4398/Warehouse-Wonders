/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WControl extends SubsystemBase {
  /**
   * Creates a new WControl.
   */
  private Spark wMotor1;
  public WControl() {
    wMotor1 = new Spark (Constants.wMotor1); 

  }
  public void run(double speed) {
    wMotor1.set(speed);
  }
  public void stop() {
    wMotor1.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
