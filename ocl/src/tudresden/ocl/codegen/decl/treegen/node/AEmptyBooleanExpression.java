/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import java.util.*;
import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class AEmptyBooleanExpression extends PBooleanExpression
{

    public AEmptyBooleanExpression()
    {
    }
    public Object clone()
    {
        return new AEmptyBooleanExpression();
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEmptyBooleanExpression(this);
    }

    public String toString()
    {
        return "";
    }

    void removeChild(Node child)
    {
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }
}
