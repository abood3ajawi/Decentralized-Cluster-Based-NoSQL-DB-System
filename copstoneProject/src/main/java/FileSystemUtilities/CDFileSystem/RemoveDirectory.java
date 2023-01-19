package FileSystemUtilities.CDFileSystem;

import java.io.File;

public class RemoveDirectory {
    private String path;
    public RemoveDirectory(String path){
        this.path = path;
    }
    public void remove(){
       File directory = new File(path);
        removeFile(directory);
       directory.delete();
    }
    private void removeFile(File element) {
        if (element.isDirectory()) {
            for (File sub : element.listFiles()) {
                removeFile(sub);
            }
        }
        element.delete();
    }
}
