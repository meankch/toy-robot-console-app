package th.ssnc.toyrobot.domain;

public class TableTop {
    private static final int row = 5;
    private static final int column = 5;

    public TableTop() {}

    /**
     * Validate if the given coordinates is valid inside the existing table top
     * 
     * @param coordinates - The coordinates to validate
     * @throws Exception
    */
    public boolean isValidCoordinates(Coordinates coordinates) throws Exception {
        if (coordinates == null) 
            throw new Exception("Robot has no coordinates, please PLACE your robot on the table.");
        return !(
                coordinates.getX() > TableTop.column || coordinates.getX() < 0 ||
                        coordinates.getY() > TableTop.row || coordinates.getY() < 0
        );
    }
}
