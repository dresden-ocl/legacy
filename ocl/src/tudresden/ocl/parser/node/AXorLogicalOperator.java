/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AXorLogicalOperator extends PLogicalOperator
{
    private TXor _xor_;

    public AXorLogicalOperator()
    {
    }

    public AXorLogicalOperator(
        TXor _xor_)
    {
        setXor(_xor_);

    }
    public Object clone()
    {
        return new AXorLogicalOperator(
            (TXor) cloneNode(_xor_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAXorLogicalOperator(this);
    }

    public TXor getXor()
    {
        return _xor_;
    }

    public void setXor(TXor node)
    {
        if(_xor_ != null)
        {
            _xor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xor_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_xor_);
    }

    void removeChild(Node child)
    {
        if(_xor_ == child)
        {
            _xor_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_xor_ == oldChild)
        {
            setXor((TXor) newChild);
            return;
        }

    }
}

