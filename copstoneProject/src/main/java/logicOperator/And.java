package logicOperator;

import org.json.JSONObject;

public class And implements Operator {
    Operator[] operators;
    public And(Operator... operators){
        this.operators = operators;
    }

    @Override
    public String operatorName() {
        return "And";
    }

    @Override
    public boolean execute() {
        boolean match = true;
        for (Operator operator :operators) {
            if (!operator.execute()) {
                match = false;
                break;
            }
        }
        return match;
    }

    @Override
    public Operator[] expression() {
        return operators;
    }

    @Override
    public void existInFile(JSONObject temporaryJSONObject) {
        for (Operator operator : operators) {
            operator.existInFile(temporaryJSONObject);
        }
    }
}
