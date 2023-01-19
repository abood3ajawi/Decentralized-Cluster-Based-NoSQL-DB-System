package logicOperator;

import org.json.JSONObject;

public class Equal implements Operator {

    private  final Operator[] operators;
    private final String key;
    private final String value;
    private boolean match;

    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
    public boolean isMatch() {
        return match;
    }
    public void setMatch(boolean match){
        this.match = match;
    }
    public Equal(String key, String value){
        this.key = key;
        this.value = value;
        operators = new Operator[]{this};
    }

    @Override
    public String operatorName() {
        return "Equal";
    }

    @Override
    public boolean execute() {
     return match;
    }

    @Override
    public Operator[] expression() {
      return operators;
    }

    @Override
    public void existInFile(JSONObject temporaryJSONObject) {
        match = temporaryJSONObject.has(key) && value.equals(temporaryJSONObject.get(key));
        System.out.println(key +":"+ value+" -- > existInFile : " + match);
    }
}
