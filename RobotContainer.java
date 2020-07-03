/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveForwardAuton;
import frc.robot.commands.RawTankDrive;
import frc.robot.commands.RunW;
import frc.robot.commands.RunX;
import frc.robot.commands.RunY;
import frc.robot.commands.RunZ;
import frc.robot.commands.SolenoidCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.SolenoidSubsytem;
//import frc.robot.subsystems.SolenoidSubsytem;
import frc.robot.subsystems.WControl;
import frc.robot.subsystems.XControl;
import frc.robot.subsystems.YControl;
import frc.robot.subsystems.ZControl;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...


  private final DriveTrain driveTrain = new DriveTrain();
 
  private final WControl wControl = new WControl();
  private final XControl xControl = new XControl(); 
  private final YControl yControl = new YControl(); 
  private final ZControl zControl = new ZControl();
  
  private final Joystick leftStick = new Joystick(0); 
  private final Joystick rightStick = new Joystick(1); 
  //Thrustmasters (2) ^
  private final JoystickButton wForward = new JoystickButton(rightStick, 4);
  private final JoystickButton wBackward = new JoystickButton(leftStick, 3);
  //Wheel of Fortune Buttons (2) ^
  private final JoystickButton xForward = new JoystickButton(rightStick, 2); 
  private final JoystickButton xBackward = new JoystickButton(leftStick, 2); 
  //Mountain Climber Buttons (2) ^
  private final JoystickButton yForward = new JoystickButton(rightStick, 1); 
  private final JoystickButton yBackward = new JoystickButton(leftStick, 1);
  //Wood Chipper Buttons (2) ^
  private final JoystickButton zForward = new JoystickButton(rightStick, 3);
  private final JoystickButton zBackward = new JoystickButton(leftStick, 4);
  //Cookie Monster Buttons (2) ^
  private final DriveForwardAuton m_autoCommand = new DriveForwardAuton(driveTrain, 2, -.2);
  //Autonomous Command ^
 private final JoystickButton pewpew = new JoystickButton(rightStick, 1);
  //Solenoid Button Maybe ^
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driveTrain.setDefaultCommand(new RawTankDrive (driveTrain, () -> leftStick.getRawAxis(1)*-1, () -> rightStick.getRawAxis(1)*-1));
    // Configure the button bindings
    configureButtonBindings();

      
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    wForward.whenHeld(new RunW(wControl, Constants.wSpeed));
    wBackward.whenHeld(new RunW(wControl, Constants.wSpeed * -1));
    //Wheel of Fortune ^
    xForward.whenHeld(new RunX(xControl, Constants.xSpeed)); 
    xBackward.whenHeld(new RunX(xControl, Constants.xSpeed * -1)); 
    //Mountain Climber ^
    yForward.whenHeld(new RunY(yControl, Constants.ySpeed)); 
    yBackward.whenHeld(new RunY(yControl, Constants.ySpeed * -1));
    //Wood Chipper ^
    zForward.whenHeld(new RunZ(zControl, Constants.zSpeed));
    zBackward.whenHeld(new RunZ(zControl, Constants.zSpeed * -1));
    //Cookie Monster ^
    //pewpew.whenHeld(new SolenoidCommand(pewpew, Subsystems.SolenoidSubsytem));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}