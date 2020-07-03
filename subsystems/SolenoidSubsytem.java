/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SolenoidSubsytem extends SubsystemBase {
  /**
   * Creates a new SolenoidSubsytem.
   */
  private DoubleSolenoid solenoid;

  public SolenoidSubsytem() {
    solenoid = new DoubleSolenoid(4, 7);
  }

  /**
   * @param solenoid the solenoid to set
   */

  public void 
     setSolenoid(DoubleSolenoid.Value state) {
      solenoid.set(state);
    }
  @Override
  public void periodic() {
  }
}

