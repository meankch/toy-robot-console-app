package th.ssnc.toyrobot.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TableTopTest {
    private TableTop tableTop = new TableTop();

    @Test
    public void shouldReturnTrue_whenValidCoordinates() throws Exception {
        assertTrue(tableTop.isValidCoordinates(new Coordinates(0,0)));
    }

    @Test
    public void shouldReturnFalse_whenInValidCoordinates() throws Exception {
        assertFalse(tableTop.isValidCoordinates(new Coordinates(6,6)));
    }

    @Test
    public void shouldThrowError_whenCoordinatesNull() throws Exception {
        Throwable exception = assertThrows(Exception.class,() -> tableTop.isValidCoordinates(null));
        assertEquals("Robot has no coordinates, please PLACE your robot on the table.", exception.getMessage());
    }
}
