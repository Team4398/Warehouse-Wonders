/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Spark;

//import org.graalvm.compiler.core.amd64.AMD64MoveFactoryBase.BackupSlotProvider;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class DriveTrain extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
private Spark frontRightVictor;
private Spark frontLeftVictor;
private Spark backRightVictor;
private Spark backLeftVictor;
private DifferentialDrive m_myRobot;

private SpeedControllerGroup leftDrive; 
private SpeedControllerGroup rightDrive; 

public DriveTrain() {
  /*
  frontRightVictor = new WPI_VictorSPX (Constants.frv);
  frontLeftVictor = new WPI_VictorSPX (Constants.flv);
  backRightVictor = new WPI_VictorSPX(Constants.brv); 
  backLeftVictor = new WPI_VictorSPX(Constants.blv); 
  */
  Spark frontRightVictor = new Spark (Constants.frv);
  Spark frontLeftVictor = new Spark (Constants.flv);
  Spark backRightVictor = new Spark (Constants.brv); 
  Spark backLeftVictor = new Spark (Constants.blv); 

  leftDrive = new SpeedControllerGroup(frontLeftVictor, backLeftVictor); 
  rightDrive = new SpeedControllerGroup(frontRightVictor, backRightVictor); 
  m_myRobot = new DifferentialDrive(leftDrive, rightDrive);
  /*
  m_myRobot = new DifferentialDrive(leftDrive, rightDrive);
  m_myRobot = new DifferentialDrive(frontLeftVictor, frontRightVictor);
  */
}

  public void tankDrive(double leftSpeed, double rightSpeed) {
    
    m_myRobot.tankDrive(leftSpeed, rightSpeed);
    
  }

  public void staticDrive(double speed) {
    frontRightVictor.set(-speed * 0.6); 
    frontLeftVictor.set(speed * 0.6); 
    backLeftVictor.set(speed * 0.6);
    backRightVictor.set(-speed * 0.6);
  }

  public void stop() {
    m_myRobot.tankDrive(0, 0); 
  }
} 

/*@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
*/