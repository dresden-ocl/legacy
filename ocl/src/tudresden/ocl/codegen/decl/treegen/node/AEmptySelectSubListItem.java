/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import java.util.*;
import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class AEmptySelectSubListItem extends PSelectSubListItem
{

    public AEmptySelectSubListItem()
    {
    }
    public Object clone()
    {
        return new AEmptySelectSubListItem();
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEmptySelectSubListItem(this);
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
