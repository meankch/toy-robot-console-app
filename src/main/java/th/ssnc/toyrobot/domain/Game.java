package th.ssnc.toyrobot.domain;

import th.ssnc.toyrobot.enums.Command;
import th.ssnc.toyrobot.enums.Direction;

public class Game {
    private Robot robot;
    private TableTop tableTop;

    public Game(Robot robot, TableTop tableTop) {
        this.robot = robot;
        this.tableTop = tableTop;
    }

    /**
     * Command robot movement based on available commands
     * 
     * @param command - Command such as PLACE,MOVE,LEFT,RIGHT,REPORT
     * @param parameters - (Optional) Command parameters
     * 
     * @throws Exception
     */
    public void commandRobot(Command command, String[] parameters) throws Exception {
        switch (command) {
            case PLACE:

                if (parameters.length <= 1) 
                    throw new Exception("Invalid PLACE command, please specify coordinates/direction.");

                String[] params;
                int x = 0;
                int y = 0;
                Direction direction = null;

                params = parameters[1].split(",");
                try {
                    x = Integer.parseInt(params[0]);
                    y = Integer.parseInt(params[1]);
                    direction = Direction.valueOf(params[2]);
                } catch (Exception e) {
                    throw new Exception("Invalid data input");
                }

                placeRobot(new Coordinates(x, y), direction);

                break;
            case MOVE:
                tableTop.isValidCoordinates(robot.getCoordinates());
                Coordinates newPosition = robot.getCoordinates().getNextCoordinates(robot.getDirection());
                if (!tableTop.isValidCoordinates(newPosition))
                    throw new Exception("Coordinates invalid");
                else
                    robot.move(newPosition);
                break;
            case LEFT:
                tableTop.isValidCoordinates(robot.getCoordinates());
                robot.rotateLeft();
                break;
            case RIGHT:
                tableTop.isValidCoordinates(robot.getCoordinates());
                robot.rotateRight();
                break;
            case REPORT:
                tableTop.isValidCoordinates(robot.getCoordinates());
                System.out.println("Output: " + report());
                break;
            default:
                throw new Exception("Command not valid");
        }
    }

    /**
     * Validate input command from console
     * 
     * @param inputCommand - User input from console
     * @throws Exception
    */
    public RobotCommand validateInputCommand(String inputCommand) throws Exception {
        try {
            String[] parameters = inputCommand.split(" ");
            return new RobotCommand(
                    Command.valueOf(parameters[0]),
                    parameters);
        } catch (Exception e) {
            throw new Exception("Command not valid");
        }
    }

    /**
     * Placing a robot onto the table top
     * 
     * @param coordinates - Robot X,Y coordinates
     * @param direction - The direction robot will be facing
     * @throws Exception
    */
    public void placeRobot(Coordinates coordinates, Direction direction) throws Exception {
        if (tableTop == null)
            throw new Exception("Table Top is not available. Please set up.");

        if (coordinates == null)
            throw new Exception("Invalid robot coordinates");

        if (direction == null)
            throw new Exception("Invalid robot direction");

        if (tableTop.isValidCoordinates(coordinates))
            robot.setCoordinates(coordinates);
            robot.setDirection(direction);
    }

    /**
     * Report the current position of the robot
     * @throws Exception
     * **/
    public String report() throws Exception {
        if (robot.getCoordinates() == null)
            throw new Exception("Invalid robot coordinates");

        return robot.getCoordinates().getX() 
            + "," + robot.getCoordinates().getY() 
            + "," + robot.getDirection().toString();
    }
}
