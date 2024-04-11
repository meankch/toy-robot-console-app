package th.ssnc.toyrobot.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import th.ssnc.toyrobot.enums.Direction;

public class CoordinatesTest {
    @Test
    public void shouldFailGetNextCoordinates_whenDirectionInvalid() throws Exception {
        Coordinates coordinates = new Coordinates();

        // when
        Throwable exception = assertThrows(Exception.class, () -> coordinates.getNextCoordinates(null));

        // then
        assertEquals("Invalid robot direction", exception.getMessage());
    }

    @Test
    public void shouldGetNextCoordinates_whenValidDirection() throws Exception {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(0);
        coordinates.setY(0);

        // when
        Coordinates nextCoordinates = coordinates.getNextCoordinates(Direction.WEST);

        // then
        Integer expectedX = -1;
        Integer expectedY = 0;
        assertEquals(expectedX, nextCoordinates.getX());
        assertEquals(expectedY, nextCoordinates.getY());
    }
}
