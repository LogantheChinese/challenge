package com.example.demo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IfStatement {
    private String condition;
    private IfStatement thenClause;
    private IfStatement elseClause;
    private Boolean result;

    public boolean process(Map<String, Object> variables) {
        if (condition == null) {
            return this.result;
        } else {
            Serializable compiledExpression = MVEL.compileExpression(this.condition);
            return MVEL.executeExpression(compiledExpression, variables, Boolean.class);
        }
    }

    public Object evaluate(Map<String, Object> context) {
        if (process(context)) {
            if (thenClause.getCondition() == null) {
                return thenClause.getResult();
            } else {
                return thenClause.evaluate(context);
            }
        } else {
            if (elseClause.getCondition() == null) {
                return elseClause.getResult();
            } else {
                return elseClause.evaluate(context);
            }
        }
    }
}
