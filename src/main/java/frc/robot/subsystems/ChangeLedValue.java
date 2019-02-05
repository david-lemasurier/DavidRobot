package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;



public class ChangeLedValue extends Subsystem{
    public ChangeLedValue(){
    }

    public void setvalue(String color,int value){
        NetworkTableInstance inst =  NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("rgbled");
        NetworkTableEntry entry = table.getEntry(color);
        entry.setValue(value);
    }

    @Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
}