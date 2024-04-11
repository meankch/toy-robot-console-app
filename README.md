# Toy Robot Simulator
A Java Console Application that simulates a robot moving on a square table top of dimensions 5 x 5.

A set of commands that the application is capable of are as followings
| Command  | Definition |
| ------------- | ------------- |
| PLACE X,Y,Direction | Placing a robot at (X,Y) coordinates, facing Direction such as NORTH,SOUTH,WEST,EAST |
| RIGHT | Command the robot to turn right |
| LEFT  | Command the robot to turn left  |
| MOVE  | Command the robot to move forward in the same direction 1 step |
| REPORT | Print the report of the robot's current coordinates and the direction | 

## Technical Information
This console application is implemented with `Java 8` with `Maven`.

## Running the application locally
To run this application locally, please follow the instructions descriped below.

### Prerequisites
1) Install [Java JDK](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
2) Install [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
3) (Optional) Install [VS Code](https://code.visualstudio.com/download)

### Running the application
1) Compile the source code `mvn compile`
2) Then, run the tests in the source code with `mvn test` to ensure all the tests passed
3) To create a JAR for the application, execute command `mvn package`
4) Execute command `mvn exec:java` to start the console application