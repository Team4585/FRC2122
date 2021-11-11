package frc.robot.biblioteca.autonomous;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

import frc.robot.biblioteca.*;
import frc.robot.biblioteca.basesubsystem.*;
public final class AutoInterpretor {
    public AutoInterpretor() {
    }
    public static ArrayList<AutoTask> interpret(String filePath, Drive driveTrain) {
        ArrayList<AutoTask> tasks = new ArrayList<AutoTask>();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] sections = data.split(" ");
                switch(sections[0]) {
                    case "say":
                        tasks.add(new AutoTaskOutput(data.replace(sections[0], "")));
                        break;
                    case "wait":
                        tasks.add(new AutoTaskWait(Long.parseLong(sections[1])));
                        break;
                    case "drive":
                        tasks.add(new AutoTaskGoToLocation(driveTrain, new HuskyVector2D(Double.parseDouble(sections[1]), Double.parseDouble(sections[2]))));
                        break;
                    case "rotate":
                        tasks.add(new AutoTaskGoToRotation(driveTrain, Double.parseDouble(sections[1])));
                        break;
                }
                System.out.println(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return tasks;
    }
}