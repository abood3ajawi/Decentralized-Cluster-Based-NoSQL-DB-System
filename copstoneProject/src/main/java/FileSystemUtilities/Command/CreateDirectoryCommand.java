package FileSystemUtilities.Command;


import FileSystemUtilities.Command.Command;
import FileSystemUtilities.Command.FileSystemReceiver;

public class CreateDirectoryCommand implements Command {
    private final FileSystemReceiver fileSystem;
    String path;
    public CreateDirectoryCommand(FileSystemReceiver fileSystem, String path){
        this.fileSystem=fileSystem;
        this.path = path;;
    }
    @Override
    public void execute() {
        fileSystem.createDirectory(path);
    }
}
