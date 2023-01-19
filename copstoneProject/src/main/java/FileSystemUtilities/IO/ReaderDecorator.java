package FileSystemUtilities.IO;

// read file format name it .
public abstract class ReaderDecorator extends FileOperation {
    FileOperation fileOperation;

    public ReaderDecorator(FileOperation fileOperation) {
        super(fileOperation.getPath());
        this.fileOperation = fileOperation;
    }
}
