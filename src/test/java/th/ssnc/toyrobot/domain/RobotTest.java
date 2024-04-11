package th.ssnc.toyrobot.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import th.ssnc.toyrobot.enums.Direction;

public class RobotTest {
    
    @Test
    public void shouldHaveNewCoordinates_whenRobotMove() throws Exception {
        Integer expectedX = 1;
        Integer expectedY = 0;

        Robot robot = new Robot();
        Coordinates current = new Coordinates(0,0);
        robot.setCoordinates(current);
        robot.setDirection(Direction.NORTH);

        // when
        Coordinates newCoordinates = new Coordinates(expectedX,expectedY);
        robot.move(newCoordinates);

        // then
        assertEquals(expectedX, robot.getCoordinates().getX());
        assertEquals(expectedY, robot.getCoordinates().getY());
    }

    @Test
    public void shouldFailMovingRobot_whenCoordinatesInvalid() throws Exception {
        Robot robot = new Robot();
        Coordinates current = new Coordinates(0,0);
        robot.setCoordinates(current);

        // when
        Throwable exception = assertThrows(Exception.class, () -> robot.move(null));

        // then
        assertEquals("Unable to move the robot to the given invalid coordinates.", exception.getMessage());
    }

    @Test
    public void shouldRotateToLeftDirection_whenRobotRotatesLeft() throws Exception {
        Direction expectedDirection = Direction.WEST;
        
        Robot robot = new Robot();
        Coordinates current = new Coordinates(0,0);
        robot.setCoordinates(current);
        robot.setDirection(Direction.NORTH);

        // when
        robot.rotateLeft();

        // then
        assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void shouldFailRotateToLeftDirection_whenCurrentDirectionInvalid() throws Exception {       
        Robot robot = new Robot();
        Coordinates current = new Coordinates();
        current.setX(0);
        current.setY(0);
        robot.setCoordinates(current);

        // when
        Throwable exception = assertThrows(Exception.class, () -> robot.rotateLeft());

        // then
        assertEquals("Unable to rotate the robot. Please make sure you have PLACE the robot.", 
            exception.getMessage());
    }

    @Test
    public void shouldRotateToRightDirection_whenRobotRotatesRight() throws Exception {
        Direction expectedDirection = Direction.EAST;
        
        Robot robot = new Robot();
        Coordinates current = new Coordinates(0,0);
        robot.setCoordinates(current);
        robot.setDirection(Direction.NORTH);

        // when
        robot.rotateRight();

        // then
        assertEquals(expectedDirection, robot.getDirection());
    }

    @Test
    public void shouldFailRotateToRightDirection_whenCurrentDirectionInvalid() throws Exception {       
        Robot robot = new Robot();
        Coordinates current = new Coordinates();
        current.setX(0);
        current.setY(0);
        robot.setCoordinates(current);

        // when
        Throwable exception = assertThrows(Exception.class, () -> robot.rotateRight());

        // then
        assertEquals("Unable to rotate the robot. Please make sure you have PLACE the robot.", 
            exception.getMessage());
    }
}
