package th.ssnc.toyrobot;

import java.io.Console;
import th.ssnc.toyrobot.domain.RobotCommand;
import th.ssnc.toyrobot.domain.Game;
import th.ssnc.toyrobot.domain.TableTop;
import th.ssnc.toyrobot.domain.Robot;

public class Main {

    public static void main(String[] args) {
        System.out.println("Toy Robot Simulator");

        Console console = System.console();
        if (console == null) {
            System.err.println("Console is null. Terminating the application..");
            System.exit(1);
        }

        Robot robot = new Robot();
        TableTop tableTop = new TableTop();
        Game game = new Game(robot, tableTop);

        System.out.println("==========================================");
        System.out.println("Available set of commands are:");
        System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");

        boolean keepRunning = true;
        while (keepRunning) {
            String inputString = console.readLine(": ");
            
            if (inputString.equals("EXIT")) {
                keepRunning = false;
            }

            try {
                RobotCommand robotCommand = game.validateInputCommand(inputString);
                game.commandRobot(robotCommand.getCommand(), robotCommand.getParameters());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
