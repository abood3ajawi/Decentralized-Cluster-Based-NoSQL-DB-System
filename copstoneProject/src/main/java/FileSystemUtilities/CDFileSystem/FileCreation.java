package FileSystemUtilities.CDFileSystem;

import java.io.File;
import java.io.IOException;

public class FileCreation {
    private final String path ;
    private final String fileName ;
    public FileCreation(String path ){
        this.path = path;
        this.fileName= (new FileName(path)).getFileName();
    }
    public File createFile() throws IOException {
        File file = new File(path+"/"+fileName+".json");
        System.out.println(file.getAbsolutePath());
        if(!file.createNewFile()){
            System.out.println("File not created !");
        }
        return file;
    }

}
