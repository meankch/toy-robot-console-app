package th.ssnc.toyrobot.domain;

import java.util.Arrays;
import th.ssnc.toyrobot.enums.Command;

public class RobotCommand {
    private Command command;
    private String[] parameters;

    public RobotCommand() {}

    public RobotCommand(Command command, String[] parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    public Command getCommand() {
        return command;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "RobotCommand{" +
                "command=" + command +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }
}
