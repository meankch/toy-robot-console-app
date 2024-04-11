package th.ssnc.toyrobot.domain;

import th.ssnc.toyrobot.enums.Direction;

public class Coordinates {
    private Integer x;
    private Integer y;

    public Coordinates() {}

    public Coordinates(Coordinates coordinates) {
        this.x = coordinates.getX();
        this.y = coordinates.getY();
    }

    public Coordinates(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * Update coordinate X & Y 
     * @param x
     * @param y
     */
    public void change(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    /**
     * Get the next coordinates computed by the current value
     * 
     * @param direction - Current robot direction
     * @return Coordinates
     * @throws Exception
     */
    public Coordinates getNextCoordinates(Direction direction) throws Exception {
        if (direction == null)
            throw new Exception("Invalid robot direction");

        // new position to validate
        Coordinates newCoordinates = new Coordinates(this);
        switch (direction) {
            case NORTH:
                newCoordinates.change(0, 1);
                break;
            case EAST:
                newCoordinates.change(1, 0);
                break;
            case SOUTH:
                newCoordinates.change(0, -1);
                break;
            case WEST:
                newCoordinates.change(-1, 0);
                break;
        }
        return newCoordinates;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
