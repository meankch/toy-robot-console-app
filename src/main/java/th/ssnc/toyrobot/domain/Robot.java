package th.ssnc.toyrobot.domain;

import th.ssnc.toyrobot.enums.Direction;

public class Robot {
    private Coordinates coordinates;
    private Direction direction;

    public Robot() {}

    public Robot(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Moves the robot to the new coordinates in the same direction
     * @throws Exception 
     */
    public void move(Coordinates newCoordinates) throws Exception {
        if (newCoordinates == null)
            throw new Exception("Unable to move the robot to the given invalid coordinates.");

        this.coordinates = newCoordinates;
    }

    /**
     * Rotates the robot 90 degrees LEFT
     * @throws Exception 
     */
    public void rotateLeft() throws Exception {
        if (this.direction == null)
            throw new Exception("Unable to rotate the robot. Please make sure you have PLACE the robot.");

        this.setDirection(direction.leftDirection());;
    }

    /**
     * Rotates the robot 90 degrees RIGHT
     * @throws Exception 
     */
    public void rotateRight() throws Exception {
        if (this.direction == null)
            throw new Exception("Unable to rotate the robot. Please make sure you have PLACE the robot.");

        this.setDirection(direction.rightDirection());;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "coordinates=" + coordinates +
                ", direction=" + direction +
                '}';
    }
}
