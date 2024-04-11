package th.ssnc.toyrobot.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import org.junit.After;
import org.junit.Test;
import th.ssnc.toyrobot.enums.Command;
import th.ssnc.toyrobot.enums.Direction;

public class GameTest {

    private Robot robot = new Robot();
    private TableTop tableTop = new TableTop();

    @After
    public void cleanUpEach(){
        robot.setCoordinates(null);
        robot.setDirection(null);
    }

    @Test
    public void shouldPlaceRobot_whenValidCoodinates() throws Exception {
        // when
        Coordinates coordinates = new Coordinates(0,0);
        Game game = new Game(robot, tableTop);

        // then
        game.placeRobot(coordinates, Direction.NORTH);

        assertEquals(coordinates.getX(), robot.getCoordinates().getX());
        assertEquals(coordinates.getY(), robot.getCoordinates().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void shouldPlaceRobotFailed_whenInvalidTableTop() throws Exception {
        // when
        Game game = new Game(robot, null);
        Coordinates coordinates = new Coordinates(0,0);

        // then
        Throwable exception = assertThrows(Exception.class, () -> game.placeRobot(coordinates,Direction.NORTH));
        assertEquals("Table Top is not available. Please set up.", exception.getMessage());    
    }

    @Test
    public void shouldPlaceRobotFailed_whenInvalidCoordinates() throws Exception {
        // when
        Game game = new Game(robot, tableTop);

        // then
        Throwable exception = assertThrows(Exception.class, () -> game.placeRobot(null, null));
        assertEquals("Invalid robot coordinates", exception.getMessage());    
    }

    @Test
    public void shouldPlaceRobotFailed_whenInvalidDirection() throws Exception {
        // when
        Game game = new Game(robot, tableTop);
        Coordinates coordinates = new Coordinates(0,0);

        // then
        Throwable exception = assertThrows(Exception.class, () -> game.placeRobot(coordinates, null));
        assertEquals("Invalid robot direction", exception.getMessage());    
    }

    @Test
    public void shouldReturnValidCommandParam_whenInputCommandValid() throws Exception {
        // when
        Game game = new Game(robot, tableTop);

        // then
        RobotCommand robotCommand = game.validateInputCommand("PLACE 0,0,NORTH");

        assertEquals(Command.PLACE, robotCommand.getCommand());
        assertEquals(Arrays.toString(new String[] {"PLACE","0,0,NORTH"}), 
            Arrays.toString(robotCommand.getParameters()));
    }

    @Test
    public void shouldThrowInValidCommandParam_whenInputCommandInValid() throws Exception {
        // when
        Game game = new Game(robot, tableTop);

        // then
        Throwable exception = assertThrows(Exception.class, () -> game.validateInputCommand("dummy"));
        assertEquals("Command not valid", exception.getMessage());   
    }

    @Test
    public void shouldReturnRobotReport_whenCoordinatesValid() throws Exception {
        // when
        robot.setCoordinates(new Coordinates(0,0));
        robot.setDirection(Direction.NORTH);
        Game game = new Game(robot, tableTop);

        // then
        String reportResult = game.report();

        assertEquals("0,0,NORTH", reportResult);
    }

    @Test
    public void shouldThrowErrorRobotReport_whenCoordinatesInValid() throws Exception {
        // when
        Game game = new Game(robot, tableTop);

        // then
        Throwable exception = assertThrows(Exception.class, () -> game.report());
        assertEquals("Invalid robot coordinates/direction", exception.getMessage());   
    }

    @Test
    public void shouldFailPlaceCommandMovement_whenParameterInvalid() throws Exception {
        // when
        Game game = new Game(robot, tableTop);

        // then
        Throwable exception = assertThrows(Exception.class, 
            () -> game.commandRobot(Command.PLACE, new String[] {}));
        assertEquals("Invalid PLACE command, please specify coordinates/direction.", exception.getMessage());
    }

    @Test
    public void shouldFailPlaceCommandMovement_whenDirectionInvalid() throws Exception {
        // when
        Game game = new Game(robot, tableTop);

        // then
        Throwable exception = assertThrows(Exception.class, 
            () -> game.commandRobot(Command.PLACE, new String[] {"PLACE","0,0"}));
        assertEquals("Invalid data input", exception.getMessage());
    }

    @Test
    public void shouldPlaceCommandMovement_whenCommandValid() throws Exception {
        // given
        Coordinates coordinates = new Coordinates(0,0);
        Game game = new Game(robot, tableTop);

        // when
        game.commandRobot(Command.PLACE, new String[] {"PLACE", "0,0,NORTH"});

        // then
        assertEquals(coordinates.getX(), robot.getCoordinates().getX());
        assertEquals(coordinates.getY(), robot.getCoordinates().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void shouldMoveCommandMovement_whenCommandValid() throws Exception {
        // given
        Coordinates coordinates = new Coordinates(0,0);
        robot.setCoordinates(coordinates);
        robot.setDirection(Direction.NORTH);

        Game game = new Game(robot, tableTop);

        // when
        game.commandRobot(Command.MOVE, new String[] {"MOVE"});

        // then
        Integer expectedX = 0;
        Integer expectedY = 1;

        assertEquals(expectedX, robot.getCoordinates().getX());
        assertEquals(expectedY, robot.getCoordinates().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void shouldLeftCommandMovement_whenCommandValid() throws Exception {
        // when
        Coordinates coordinates = new Coordinates(0,0);
        robot.setCoordinates(coordinates);
        robot.setDirection(Direction.NORTH);

        Game game = new Game(robot, tableTop);

        // then
        game.commandRobot(Command.LEFT, new String[] {"LEFT"});

        Integer expectedX = 0;
        Integer expectedY = 0;
        
        assertEquals(expectedX, robot.getCoordinates().getX());
        assertEquals(expectedY, robot.getCoordinates().getY());
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    public void shouldRightCommandMovement_whenCommandValid() throws Exception {
        // when
        Coordinates coordinates = new Coordinates(0,0);
        robot.setCoordinates(coordinates);
        robot.setDirection(Direction.NORTH);

        Game game = new Game(robot, tableTop);

        // then
        game.commandRobot(Command.RIGHT, new String[] {"RIGHT"});

        Integer expectedX = 0;
        Integer expectedY = 0;
        
        assertEquals(expectedX, robot.getCoordinates().getX());
        assertEquals(expectedY, robot.getCoordinates().getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }
}
