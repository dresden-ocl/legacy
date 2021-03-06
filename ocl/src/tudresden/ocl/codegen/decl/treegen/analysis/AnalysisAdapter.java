/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.analysis;

import java.util.*;
import tudresden.ocl.codegen.decl.treegen.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable in;
    private Hashtable out;

    public Object getIn(Node node)
    {
        if(in == null)
        {
            return null;
        }

        return in.get(node);
    }

    public void setIn(Node node, Object in)
    {
        if(this.in == null)
        {
            this.in = new Hashtable(1);
        }

        if(in != null)
        {
            this.in.put(node, in);
        }
        else
        {
            this.in.remove(node);
        }
    }

    public Object getOut(Node node)
    {
        if(out == null)
        {
            return null;
        }

        return out.get(node);
    }

    public void setOut(Node node, Object out)
    {
        if(this.out == null)
        {
            this.out = new Hashtable(1);
        }

        if(out != null)
        {
            this.out.put(node, out);
        }
        else
        {
            this.out.remove(node);
        }
    }
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    public void caseAUnionQueryExpression(AUnionQueryExpression node)
    {
        defaultCase(node);
    }

    public void caseAIntersectQueryExpression(AIntersectQueryExpression node)
    {
        defaultCase(node);
    }

    public void caseAExceptQueryExpression(AExceptQueryExpression node)
    {
        defaultCase(node);
    }

    public void caseAQuerySpecQueryExpression(AQuerySpecQueryExpression node)
    {
        defaultCase(node);
    }

    public void caseAEmptyQueryExpression(AEmptyQueryExpression node)
    {
        defaultCase(node);
    }

    public void caseASelectClause(ASelectClause node)
    {
        defaultCase(node);
    }

    public void caseADistinctSetQuantifier(ADistinctSetQuantifier node)
    {
        defaultCase(node);
    }

    public void caseAAllSetQuantifier(AAllSetQuantifier node)
    {
        defaultCase(node);
    }

    public void caseAEmptySetQuantifier(AEmptySetQuantifier node)
    {
        defaultCase(node);
    }

    public void caseAAsteriskSelectList(AAsteriskSelectList node)
    {
        defaultCase(node);
    }

    public void caseAFunctionSelectList(AFunctionSelectList node)
    {
        defaultCase(node);
    }

    public void caseASubListSelectList(ASubListSelectList node)
    {
        defaultCase(node);
    }

    public void caseAEmptySelectList(AEmptySelectList node)
    {
        defaultCase(node);
    }

    public void caseAStringSelectSubListItem(AStringSelectSubListItem node)
    {
        defaultCase(node);
    }

    public void caseAColumnSelectSubListItem(AColumnSelectSubListItem node)
    {
        defaultCase(node);
    }

    public void caseAEmptySelectSubListItem(AEmptySelectSubListItem node)
    {
        defaultCase(node);
    }

    public void caseAColumn(AColumn node)
    {
        defaultCase(node);
    }

    public void caseAFromClause(AFromClause node)
    {
        defaultCase(node);
    }

    public void caseATableNameTableReference(ATableNameTableReference node)
    {
        defaultCase(node);
    }

    public void caseADerivedTableTableReference(ADerivedTableTableReference node)
    {
        defaultCase(node);
    }

    public void caseAEmptyTableReference(AEmptyTableReference node)
    {
        defaultCase(node);
    }

    public void caseAWhereClause(AWhereClause node)
    {
        defaultCase(node);
    }

    public void caseAAndBooleanExpression(AAndBooleanExpression node)
    {
        defaultCase(node);
    }

    public void caseAOrBooleanExpression(AOrBooleanExpression node)
    {
        defaultCase(node);
    }

    public void caseANotBooleanExpression(ANotBooleanExpression node)
    {
        defaultCase(node);
    }

    public void caseANullBooleanExpression(ANullBooleanExpression node)
    {
        defaultCase(node);
    }

    public void caseAInBooleanExpression(AInBooleanExpression node)
    {
        defaultCase(node);
    }

    public void caseAExistsBooleanExpression(AExistsBooleanExpression node)
    {
        defaultCase(node);
    }

    public void caseARExpBooleanExpression(ARExpBooleanExpression node)
    {
        defaultCase(node);
    }

    public void caseATrueBooleanExpression(ATrueBooleanExpression node)
    {
        defaultCase(node);
    }

    public void caseAFalseBooleanExpression(AFalseBooleanExpression node)
    {
        defaultCase(node);
    }

    public void caseAEmptyBooleanExpression(AEmptyBooleanExpression node)
    {
        defaultCase(node);
    }

    public void caseAEqRelationalExpression(AEqRelationalExpression node)
    {
        defaultCase(node);
    }

    public void caseANeqRelationalExpression(ANeqRelationalExpression node)
    {
        defaultCase(node);
    }

    public void caseAGtRelationalExpression(AGtRelationalExpression node)
    {
        defaultCase(node);
    }

    public void caseALtRelationalExpression(ALtRelationalExpression node)
    {
        defaultCase(node);
    }

    public void caseAGteqRelationalExpression(AGteqRelationalExpression node)
    {
        defaultCase(node);
    }

    public void caseALteqRelationalExpression(ALteqRelationalExpression node)
    {
        defaultCase(node);
    }

    public void caseANumExpRelationalExpression(ANumExpRelationalExpression node)
    {
        defaultCase(node);
    }

    public void caseAEmptyRelationalExpression(AEmptyRelationalExpression node)
    {
        defaultCase(node);
    }

    public void caseAMultNumericExpression(AMultNumericExpression node)
    {
        defaultCase(node);
    }

    public void caseADivNumericExpression(ADivNumericExpression node)
    {
        defaultCase(node);
    }

    public void caseAPlusNumericExpression(APlusNumericExpression node)
    {
        defaultCase(node);
    }

    public void caseAMinusNumericExpression(AMinusNumericExpression node)
    {
        defaultCase(node);
    }

    public void caseAValueNumericExpression(AValueNumericExpression node)
    {
        defaultCase(node);
    }

    public void caseAEmptyNumericExpression(AEmptyNumericExpression node)
    {
        defaultCase(node);
    }

    public void caseANumericUnaryExpression(ANumericUnaryExpression node)
    {
        defaultCase(node);
    }

    public void caseAStringUnaryExpression(AStringUnaryExpression node)
    {
        defaultCase(node);
    }

    public void caseAColumnUnaryExpression(AColumnUnaryExpression node)
    {
        defaultCase(node);
    }

    public void caseAFunctionUnaryExpression(AFunctionUnaryExpression node)
    {
        defaultCase(node);
    }

    public void caseABooleanUnaryExpression(ABooleanUnaryExpression node)
    {
        defaultCase(node);
    }

    public void caseAParUnaryExpression(AParUnaryExpression node)
    {
        defaultCase(node);
    }

    public void caseAQueryUnaryExpression(AQueryUnaryExpression node)
    {
        defaultCase(node);
    }

    public void caseAMinusUnaryExpression(AMinusUnaryExpression node)
    {
        defaultCase(node);
    }

    public void caseAEmptyUnaryExpression(AEmptyUnaryExpression node)
    {
        defaultCase(node);
    }

    public void caseTNewLine(TNewLine node)
    {
        defaultCase(node);
    }

    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    public void caseTTab(TTab node)
    {
        defaultCase(node);
    }

    public void caseTUnion(TUnion node)
    {
        defaultCase(node);
    }

    public void caseTIntersect(TIntersect node)
    {
        defaultCase(node);
    }

    public void caseTExcept(TExcept node)
    {
        defaultCase(node);
    }

    public void caseTAll(TAll node)
    {
        defaultCase(node);
    }

    public void caseTTrue(TTrue node)
    {
        defaultCase(node);
    }

    public void caseTFalse(TFalse node)
    {
        defaultCase(node);
    }

    public void caseTAsterisk(TAsterisk node)
    {
        defaultCase(node);
    }

    public void caseTIdentifier(TIdentifier node)
    {
        defaultCase(node);
    }

    public void caseTNumericValue(TNumericValue node)
    {
        defaultCase(node);
    }

    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    public void defaultCase(Node node)
    {
    }
}
