package FileSystemUtilities.Command;

import java.io.IOException;

public class CreateFileCommand implements Command {
    private final FileSystemReceiver fileSystem;
    String path;
    public  CreateFileCommand(FileSystemReceiver fileSystem , String path){
        this.fileSystem=fileSystem;
        this.path = path;;
    }
    @Override
    public void execute() throws IOException {
        fileSystem.createFile(path);
    }
}
