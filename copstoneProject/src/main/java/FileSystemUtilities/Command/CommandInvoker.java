package FileSystemUtilities.Command;

import FileSystemUtilities.Command.Command;

import java.io.IOException;

public class CommandInvoker {

    public Command command;

    public CommandInvoker(Command c){
        this.command=c;
    }

    public void execute() throws IOException {
        this.command.execute();
    }
}
