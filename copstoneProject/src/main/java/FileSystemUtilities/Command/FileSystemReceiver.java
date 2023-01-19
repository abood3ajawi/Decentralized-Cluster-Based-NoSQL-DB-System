package FileSystemUtilities.Command;


import FileSystemUtilities.CDFileSystem.*;


import java.io.File;
import java.io.IOException;

public class FileSystemReceiver  {
    String path ;
    public FileSystemReceiver(String path){
        this.path = path;
    }
    public void createDirectory(String path) {
        DirectoryCreation directory = new DirectoryCreation(path);
        directory.createDirectory();
    }
    public void createFile(String path) throws IOException {
        FileCreation file = new FileCreation(path);
        file.createFile();
    }
    public void removeFile(String path){
        RemoveFile directory = new RemoveFile(path);

    }
    public void removeDirectory(String path){
        RemoveDirectory directory = new RemoveDirectory(path);
        directory.remove();
    }
}
