/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AImpliesLogicalOperator extends PLogicalOperator
{
    private TImplies _implies_;

    public AImpliesLogicalOperator()
    {
    }

    public AImpliesLogicalOperator(
        TImplies _implies_)
    {
        setImplies(_implies_);

    }
    public Object clone()
    {
        return new AImpliesLogicalOperator(
            (TImplies) cloneNode(_implies_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAImpliesLogicalOperator(this);
    }

    public TImplies getImplies()
    {
        return _implies_;
    }

    public void setImplies(TImplies node)
    {
        if(_implies_ != null)
        {
            _implies_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _implies_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_implies_);
    }

    void removeChild(Node child)
    {
        if(_implies_ == child)
        {
            _implies_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_implies_ == oldChild)
        {
            setImplies((TImplies) newChild);
            return;
        }

    }
}

