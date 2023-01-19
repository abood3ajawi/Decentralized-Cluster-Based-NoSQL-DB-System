package logicOperator;

import org.json.JSONObject;

public class Or implements Operator {
    Operator[] operators;
    public  Or(Operator...operators){
        this.operators = operators;
    }
    @Override
    public String operatorName() {
        return null;
    }
    @Override
    public boolean execute() {
        boolean match = false;
        for (Operator operator : operators) {
            if (operator.execute()) {
                match = true;
                break;
            }
        }
        return match;
    }

    @Override
    public Operator[] expression() {
    return operators ;
    }

    @Override
    public void existInFile(JSONObject temporaryJSONObject) {
        System.out.println(operators.length);
        for (Operator operator : operators) {
            operator.existInFile(temporaryJSONObject);
        }
    }
}
