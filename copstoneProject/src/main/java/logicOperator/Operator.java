package logicOperator;

import org.json.JSONObject;

public interface Operator {
    public  String operatorName();
    public  boolean execute();
    public  Operator[] expression();
    public   void existInFile(JSONObject temporaryJSONObject);
}
