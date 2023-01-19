package FileSystemUtilities.IO;

import logicOperator.Operator;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Find extends ReaderDecorator {
        public Find(FileOperation fileOperation){
            super(fileOperation);
        }
        public ArrayList<JSONObject> find(Operator expression) throws IOException {
            File[] files =  new File(this.getPath()).listFiles();
            ArrayList<JSONObject> data = new ArrayList<>();
            for (int i = 0; i < Objects.requireNonNull(files).length ; i++) {
                if(!files[i].isDirectory()) {
                    JSONObject temporaryJSONObject = ((ReadFile) fileOperation).readFile(files[i].getName());
                    expression.existInFile(temporaryJSONObject);
                    if (expression.execute()) {
                        data.add(temporaryJSONObject);
                    }
                }
            }
            return  data ;
        }
}
