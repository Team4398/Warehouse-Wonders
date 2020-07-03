/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WControl;

public class RunW extends CommandBase {
  /**
   * Creates a new RunW.
   */
  private WControl wControl;

  private double speed;
  public RunW(WControl wControl, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.wControl = wControl; 
    this.speed = speed; 
    addRequirements(wControl);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    wControl.stop(); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    wControl.run(speed); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    wControl.stop(); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
