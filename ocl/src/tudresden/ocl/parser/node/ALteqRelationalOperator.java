/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class ALteqRelationalOperator extends PRelationalOperator
{
    private TLteq _lteq_;

    public ALteqRelationalOperator()
    {
    }

    public ALteqRelationalOperator(
        TLteq _lteq_)
    {
        setLteq(_lteq_);

    }
    public Object clone()
    {
        return new ALteqRelationalOperator(
            (TLteq) cloneNode(_lteq_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALteqRelationalOperator(this);
    }

    public TLteq getLteq()
    {
        return _lteq_;
    }

    public void setLteq(TLteq node)
    {
        if(_lteq_ != null)
        {
            _lteq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lteq_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_lteq_);
    }

    void removeChild(Node child)
    {
        if(_lteq_ == child)
        {
            _lteq_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_lteq_ == oldChild)
        {
            setLteq((TLteq) newChild);
            return;
        }

    }
}

