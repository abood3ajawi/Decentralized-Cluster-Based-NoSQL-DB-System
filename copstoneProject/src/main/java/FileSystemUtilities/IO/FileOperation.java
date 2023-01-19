package FileSystemUtilities.IO;


public abstract class FileOperation {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileOperation(String path) {
        this.path = path;
    }
}
