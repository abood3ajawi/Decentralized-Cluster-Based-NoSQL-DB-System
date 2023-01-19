package FileSystemUtilities.CDFileSystem;

import java.io.File;

public class DirectoryCreation {
    File Directory ;
    public DirectoryCreation(String path){
        Directory = new File(path);
    }
    public void createDirectory() {
        if (!Directory.exists())
            if (Directory.mkdirs())
                System.out.println("Directory do !");
            else
                System.out.println("Deny  creating directory ! ");
        else
            System.out.println("directory exist");
    }
}